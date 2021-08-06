package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.dto.Carrito;
import ar.com.educacionit.web.enums.CarritoKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/ActualizarCarritoController")
public class ActualizarCarritoController extends BaseServlet{

	private static final long serialVersionUID = 484371981528390336L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter(CarritoKeyEnums.ID.name()));
		
		Integer cantidad = Integer.decode(req.getParameter(CarritoKeyEnums.CANTIDAD.name()));
		
		Carrito carrito = (Carrito)req.getSession().getAttribute(CarritoKeyEnums.CARRITO.name());
		
		if(carrito != null) {
			carrito.update(id, cantidad);
		}
		
		addAttribute(req, ViewKeyEnums.EXITO, "Articulo id: " +id + " actualizado");
		
		addAttribute(req.getSession(), CarritoKeyEnums.CARRITO, carrito);
		
		redirect(ViewEnums.CARRITO, req, resp);
	}
}
