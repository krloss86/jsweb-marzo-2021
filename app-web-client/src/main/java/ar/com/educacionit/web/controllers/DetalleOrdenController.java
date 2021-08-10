package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.OrdenesService;
import ar.com.educacionit.services.impl.OrdenesServiceImpl;
import ar.com.educacionit.web.enums.OrdenesKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;

@WebServlet("/controllers/DetalleOrdenController")
public class DetalleOrdenController extends BaseServlet {

	private final static OrdenesService service = new OrdenesServiceImpl();
	
	private static final long serialVersionUID = -4676049283383295869L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idOrden = req.getParameter(OrdenesKeyEnums.ID_ORDEN.name());
		
		if(idOrden == null) {
			addErrorMessage(req, "Debe indicar un ID de orden");
			redirect(ViewEnums.ORDENES, req, resp);
			return;
		}
		
		Ordenes orden;
		
		try {
			
			orden = service.getOne(Long.parseLong(idOrden));
			
			super.addAttribute(req.getSession(), OrdenesKeyEnums.ORDEN, orden);
			
		} catch (ServiceException e) {
			super.addErrorMessage(req,e.getMessage());
		}
		
		redirect(ViewEnums.ORDER_DETAILS, req, resp);		
	}
}
