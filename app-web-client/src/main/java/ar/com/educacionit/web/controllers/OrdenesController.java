package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.OrdenesService;
import ar.com.educacionit.services.impl.OrdenesServiceImpl;
import ar.com.educacionit.web.enums.OrdenesKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;

@WebServlet("/secure/OrdenesControllers")
public class OrdenesController extends BaseServlet {

	private final static OrdenesService service = new OrdenesServiceImpl();
	
	private static final long serialVersionUID = -4676049283383295869L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Ordenes> ordenes;
		try {
			
			User user = getUserLogged(req);
			
			ordenes = service.findAllBySocioId(user.getSocios().getId());
			
			super.addAttribute(req.getSession(), OrdenesKeyEnums.ORDENES, ordenes);
			
		} catch (ServiceException e) {
			ordenes = new ArrayList<Ordenes>();
			super.addErrorGeneral(req,e.getMessage());
		}
		
		redirect(ViewEnums.ORDENES, req, resp);		
	}
}
