package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.dto.ItemCarrito;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.web.dto.Carrito;
import ar.com.educacionit.web.enums.CarritoKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/CarritoController")
public class CarritoController extends BaseServlet{

	private static final long serialVersionUID = 484371981528390336L;
	private static ArticulosService service = new ArticuloServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer cantidad = Integer.decode(req.getParameter(CarritoKeyEnums.CANTIDAD.name()));
		
		Long id = Long.decode(req.getParameter(CarritoKeyEnums.ID.name()));
		
		Carrito carrito = (Carrito)req.getSession().getAttribute(CarritoKeyEnums.CARRITO.name());
		
		if(carrito == null) {
			carrito = new Carrito();			
		}
		
		try {
			Articulos articulo = service.getOne(id);
			ItemCarrito item = new ItemCarrito(articulo.getId(), articulo.getTitulo(), articulo.getPrecio(), cantidad);
			carrito.add(item);
			
			//mensaje de respuesta 
			resp.getWriter().print(articulo.getTitulo() + " agregado");
		} catch (ServiceException e) {
			throw new IOException(e.getCause().getMessage(),e);
		}finally {
			addAttribute(req.getSession(), CarritoKeyEnums.CARRITO, carrito);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter(CarritoKeyEnums.ID.name()));
		
		Carrito carrito = (Carrito)req.getSession().getAttribute(CarritoKeyEnums.CARRITO.name());
		
		if(carrito != null) {
			carrito.remove(id);
		}
		
		addAttribute(req, ViewKeyEnums.EXITO, "Articulo id: " +id + " eliminado");
		
		addAttribute(req.getSession(), CarritoKeyEnums.CARRITO, carrito);
		
		redirect(ViewEnums.CARRITO, req, resp);
	}
}
