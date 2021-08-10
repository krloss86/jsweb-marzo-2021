package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.CategoriasService;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.MarcasServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/controllers/CargarParaEditarProductoServlet")
public class CargarParaEditarProductoServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1914061962552127471L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		ViewEnums target = ViewEnums.EDITAR_PRODUCTO;
		
		try {
			Articulos aux = super.ps.getOne(Long.parseLong(id));
			
			addAttribute(request, ViewKeyEnums.PRODUCTO_EDITAR, aux);
			
			//cargo las categorias y marcas
			CategoriasService cs = new CategoriaServiceImpl();
			MarcasService ms = new MarcasServiceImpl();
			
			request.setAttribute("categorias",cs.findAll());
			request.setAttribute("marcas",ms.findAll());
		}catch (Exception e) {
			addAttribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
			target = ViewEnums.LISTADO_GENERAL;
			
			//recargo la lista de productos
			Collection<Articulos> productos;
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