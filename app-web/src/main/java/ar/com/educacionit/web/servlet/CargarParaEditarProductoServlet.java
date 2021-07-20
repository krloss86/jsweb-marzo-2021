package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/controllers/CargarParaEditarProductoServlet")
public class CargarParaEditarProductoServlet extends BaseServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		ViewEnums target = ViewEnums.EDITAR_PRODUCTO;
		
		try {
			Producto aux = super.ps.getById(Long.parseLong(id));
			
			addAttribute(request, ViewKeyEnums.PRODUCTO_EDITAR, aux);
		}catch (Exception e) {
			addAttribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
			target = ViewEnums.LISTADO_GENERAL;
			
			//recargo la lista de productos
			Collection<Producto> productos;
			try {
				productos = super.ps.findAll();
			} catch (ServiceException e1) {
				productos = new ArrayList<>();
			}
			request.setAttribute(ViewKeyEnums.LISTADO.name(), productos);
		}
		
		redirect(target, request, response);
	}
}