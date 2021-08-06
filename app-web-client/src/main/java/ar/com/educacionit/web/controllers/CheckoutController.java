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
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/secure/CheckoutController")
public class CheckoutController extends BaseServlet{

	private static final long serialVersionUID = 484371981528390336L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Carrito carrito = (Carrito)req.getSession().getAttribute(CarritoKeyEnums.CARRITO.name());
		
		if(carrito == null) {
			addAttribute(req, ViewKeyEnums.ERROR_GENERAL, "No hay articulos");
			redirect(ViewEnums.CARRITO, req, resp);
		}
		
		User user = getUserLogged(req);
		
		Checkout checkout = new Checkout();
		checkout.setNombre(user.getUsername() != null ? user.getUsername() : "");
		checkout.setApellido(user.getApellido() != null ? user.getApellido() : "");
		checkout.setEmail(user.getEmail() != null ? user.getEmail() : "");
		checkout.setDireccion(user.getDireccion() != null ? user.getDireccion() : "");
		checkout.setPais(user.getPais() != null ? user.getPais() : "");
		
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
		
		//tomo los datos de pantalla agregados por el usuario
		String nombre = getParameter(req,CarritoKeyEnums.NOMBRE);
		String apellido = getParameter(req,CarritoKeyEnums.APELLIDO);
		String email = getParameter(req,CarritoKeyEnums.EMAIL);
		String direccion = getParameter(req,CarritoKeyEnums.DIRECCION);
		String pais = getParameter(req,CarritoKeyEnums.PAIS);
		
		//validacion: completar
		
		checkout.setNombre(nombre);
		checkout.setApellido(apellido);
		checkout.setEmail(email);
		checkout.setDireccion(direccion);
		checkout.setPais(pais);
		
		OrdenesService ordenService = new OrdenesServiceImpl();

		Long idOrden = null;
		try {
			idOrden = ordenService.save(new ArrayList(carrito.getItems()), 8L, carrito.getTotal(), null, 4L, Long.parseLong(pais), direccion);
			
			//limpiar los datos de sesion
			req.getSession().removeAttribute(CarritoKeyEnums.CARRITO.name());
			req.getSession().removeAttribute(CarritoKeyEnums.DATOS_CHECKOUT.name());

			addAttribute(req, CarritoKeyEnums.ID_ORDEN_GENERADA, idOrden);
			redirect(ViewEnums.CHECKOUT_SUCCESS, req, resp);
		} catch (ServiceException e) {
			addAttribute(req, ViewKeyEnums.ERROR_GENERAL, e.getStackTrace());
			redirect(ViewEnums.CHECKOUT, req, resp);
		}
	}

	private String getParameter(HttpServletRequest req, Enumerable enumerable) {
		return req.getParameter(enumerable.toString());
	}
}
