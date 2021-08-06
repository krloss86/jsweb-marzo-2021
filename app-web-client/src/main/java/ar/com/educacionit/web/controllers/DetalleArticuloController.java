package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.web.enums.CarritoKeyEnums;
import ar.com.educacionit.web.enums.DetalleArticuloKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;

/**
 * Servlet implementation class BuscarProductoServlet
 */
@WebServlet("/DetalleArticuloController")
public class DetalleArticuloController extends BaseServlet {
	
	private static ArticulosService service = new ArticuloServiceImpl();
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idArticulo = req.getParameter(CarritoKeyEnums.ID.name());
		
		if(idArticulo != null && !idArticulo.trim().equals("")) {
			try {
				Articulos articulo = service.getOne(Long.parseLong(idArticulo));
				addAttribute(req, DetalleArticuloKeyEnums.ARTICULO, articulo);
			} catch (ServiceException e) {
				throw new IOException(e.getMessage(),e);
			}
		}
		
		redirect(ViewEnums.DETALLE_ARTICULO, req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
