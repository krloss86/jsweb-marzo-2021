package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.impl.SociosServiceImpl;
import ar.com.educacionit.web.enums.Enumerable;
import ar.com.educacionit.web.enums.ProfileKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/secure/ProfileController")
public class ProfileController extends BaseServlet{

	private static final long serialVersionUID = 484371981528390336L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = getUserLogged(req);
		
		//tomo los datos de pantalla agregados por el usuario
		String nombre = getParameter(req,ProfileKeyEnums.NOMBRE);
		String apellido = getParameter(req,ProfileKeyEnums.APELLIDO);
		String email = getParameter(req,ProfileKeyEnums.EMAIL);
		String direccion = getParameter(req,ProfileKeyEnums.DIRECCION);
		//String pais = getParameter(req,ProfileKeyEnums.PAIS);
		
		//validacion: completar
		
		user.getSocios().setNombre(nombre);
		user.getSocios().setApellido(apellido);
		user.getSocios().setEmail(email);
		user.getSocios().setDireccion(direccion);
		//user.getSocios().setPais(Long.parseLong(pais));
		
		SociosService sociosService = new SociosServiceImpl();

		try {
			sociosService.update(user.getSocios());
			
			addAttribute(req.getSession(), ViewKeyEnums.USUARIO, user);

			super.addExitoGeneral(req, "Datos actualizado");

		} catch (ServiceException | DuplicatedException e) {
			super.addErrorGeneral(req, e.getMessage());
		}
		
		redirect(ViewEnums.LOGIN_SUCCESS, req, resp);
	}

	private String getParameter(HttpServletRequest req, Enumerable enumerable) {
		return req.getParameter(enumerable.toString());
	}
}
