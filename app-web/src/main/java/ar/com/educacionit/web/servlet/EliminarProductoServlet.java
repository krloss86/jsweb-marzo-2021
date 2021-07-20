package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
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
		
		//validaciones
		if(id == null || id.trim().equals("")) {
			super.addAttribute(request, ViewKeyEnums.ERROR_GENERAL, id);
			getServletContext().getRequestDispatcher(target.getView()).forward(request, response);			
		}
		
		try {
			Long idLong = Long.parseLong(id);
			super.ps.eliminarProducto(idLong);
			addAttribute(request, ViewKeyEnums.EXITO, "Se ha eliminado el producto id: " +id);
			
		} catch (ServiceException | RuntimeException e) {				
			addAttribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
		} finally {
			Collection<Producto> productos;
			try {
				productos = super.ps.findAll();
			} catch (ServiceException e) {
				productos = new ArrayList<Producto>();
			}
			addAttribute(request, ViewKeyEnums.LISTADO, productos);
			
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}

}
