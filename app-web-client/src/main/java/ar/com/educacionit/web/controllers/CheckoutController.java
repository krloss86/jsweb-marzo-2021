package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.MediosPagos;
import ar.com.educacionit.domain.Paises;
import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.OrdenesService;
import ar.com.educacionit.services.impl.MediosPagosServiceImpl;
import ar.com.educacionit.services.impl.OrdenesServiceImpl;
import ar.com.educacionit.services.impl.PaisesServiceImpl;
import ar.com.educacionit.web.dto.Carrito;
import ar.com.educacionit.web.dto.Checkout;
import ar.com.educacionit.web.enums.CarritoKeyEnums;
import ar.com.educacionit.web.enums.Enumerable;
import ar.com.educacionit.web.enums.ProfileKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/secure/CheckoutController")
public class CheckoutController extends BaseServlet{

	private static final long serialVersionUID = 484371981528390336L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Carrito carrito = (Carrito)req.getSession().getAttribute(CarritoKeyEnums.CARRITO.name());
		
		if(carrito == null) {
			super.addErrorMessage(req,"No hay articulos");
			redirect(ViewEnums.CARRITO, req, resp);
		}
		
		User user = getUserLogged(req);
		
		Checkout checkout = new Checkout();
		checkout.setNombre(user.getSocios().getNombre());
		checkout.setApellido(user.getSocios().getApellido());
		checkout.setEmail(user.getSocios().getEmail());
		checkout.setDireccion(user.getSocios().getDireccion());
		checkout.setPaisesId(user.getSocios().getPaisesId());
		
		try {
			List<Paises> paises = new PaisesServiceImpl().findAll();
			addAttribute(req, CarritoKeyEnums.PAISES, paises);
			
			addAttribute(req.getSession(), CarritoKeyEnums.DATOS_CHECKOUT, checkout);
			
			List<MediosPagos> mediosPagos = new MediosPagosServiceImpl().findAll();
			addAttribute(req.getSession(), CarritoKeyEnums.MEDIOS_PAGOS, mediosPagos);
		} catch (ServiceException e) {
			throw new IOException(e.getMessage(),e);
		}
		
		redirect(ViewEnums.CHECKOUT, req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Carrito carrito = (Carrito)req.getSession().getAttribute(CarritoKeyEnums.CARRITO.name());
		
		if(carrito == null) {
			addAttribute(req, ViewKeyEnums.ERROR_GENERAL, "No hay articulos");
			redirect(ViewEnums.CARRITO, req, resp);
		}
		
		User user = getUserLogged(req);
		
		Checkout checkout = (Checkout)req.getSession().getAttribute(CarritoKeyEnums.DATOS_CHECKOUT.name());
		
		//tomo los datos de pantalla agregados por el usuario, pueden ser diferentes al del socio que esta asociado al user
		String nombre = getParameter(req,ProfileKeyEnums.NOMBRE);
		String apellido = getParameter(req,ProfileKeyEnums.APELLIDO);
		String email = getParameter(req,ProfileKeyEnums.EMAIL);
		String direccion = getParameter(req,ProfileKeyEnums.DIRECCION);
		String paisesId = getParameter(req,ProfileKeyEnums.PAIS);
		String medioPago = getParameter(req, CarritoKeyEnums.MEDIO_PAGO);
		
		//validacion: completar
		
		checkout.setNombre(nombre);
		checkout.setApellido(apellido);
		checkout.setEmail(email);
		checkout.setDireccion(direccion);
		checkout.setPaisesId(Long.parseLong(paisesId));
		
		if(medioPago == null || medioPago.equals("")) {
			addErrorMessage(req, "Debe seleccionar un Medio de Pago");
			doGet(req, resp);
		}else {
		
			OrdenesService ordenService = new OrdenesServiceImpl();
	
			Long idOrden = null;
			try {
				idOrden = ordenService.save(new ArrayList(carrito.getItems()),
						user.getSocios().getId(), 
						carrito.getTotal(), 
						null,
						Long.parseLong(medioPago), 
						Long.parseLong(paisesId), 
						direccion);
				
				//limpiar los datos de sesion
				req.getSession().removeAttribute(CarritoKeyEnums.CARRITO.name());
				req.getSession().removeAttribute(CarritoKeyEnums.DATOS_CHECKOUT.name());
	
				addAttribute(req, CarritoKeyEnums.ID_ORDEN_GENERADA, idOrden);
				redirect(ViewEnums.CHECKOUT_SUCCESS, req, resp);
			} catch (ServiceException e) {
				addAttribute(req, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
				redirect(ViewEnums.CHECKOUT, req, resp);
			}
		}
	}

	private String getParameter(HttpServletRequest req, Enumerable enumerable) {
		return req.getParameter(enumerable.toString());
	}
}
