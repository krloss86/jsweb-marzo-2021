package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

/**
 * Servlet implementation class BuscarProductoServlet
 */
@WebServlet("/controllers/BuscarProductoServlet")
public class BuscarProductoServlet extends BaseServlet {
	
	private static ArticulosService service = new ArticuloServiceImpl();
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String claveBusqueda = request.getParameter(ViewKeyEnums.CLAVE_BUSQUEDA.getViewKey());
		
		if(claveBusqueda == null || claveBusqueda.trim().equals("")) {
			claveBusqueda ="";
		}
		
		List<Articulos> articulos = new ArrayList<>();
		
		try {
			articulos = service.findAllBy(claveBusqueda);		
						
			if(articulos.isEmpty()) {	
				addAttribute(request, ViewKeyEnums.WARNING_GENERAL, "No hay datos");
			}
		} catch (ServiceException e) {
			addAttribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
		} finally {
			addAttribute(request, ViewKeyEnums.LISTADO, articulos);
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getView()).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
