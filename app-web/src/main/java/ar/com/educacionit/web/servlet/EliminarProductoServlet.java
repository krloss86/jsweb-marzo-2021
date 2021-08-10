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
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

/**
 * Servlet implementation class BuscarProductoServlet
 */
@WebServlet("/controllers/EliminarProductoServlet")
public class EliminarProductoServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(ViewKeyEnums.ID_PRODUCTO.getViewKey());
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		try {
			Long idLong = Long.parseLong(id);
			super.ps.delete(idLong);
			addAttribute(request, ViewKeyEnums.EXITO, "Se ha eliminado el producto id: " +id);
			
		} catch (ServiceException | RuntimeException e) {				
			addAttribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
		} finally {
			Collection<Articulos> articulos;
			try {
				articulos = super.ps.findAll();
			} catch (ServiceException e) {
				articulos = new ArrayList<>();
			}
			addAttribute(request, ViewKeyEnums.LISTADO, articulos);
			
			Double suma = articulos.stream()
				.map(p -> p.getPrecio())
				.reduce(0D, (Double x, Double y) -> x+y);
			
			addAttribute(request, ViewKeyEnums.TOTAL, suma);
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}

}
