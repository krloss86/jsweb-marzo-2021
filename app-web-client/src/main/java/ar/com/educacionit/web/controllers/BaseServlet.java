package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.web.enums.Enumerable;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = -7368608929870113259L;
	
	//metodos
	public static void addAttribute(HttpServletRequest request, Enumerable key, Object value ) {
		//request.setAttribute(key.name(), value);
		request.setAttribute(key.toString(), value);
	}
	
	public static void addAttribute(HttpServletRequest request, ViewEnums key, Object value ) {
		request.setAttribute(key.name(), value);
	}
	
	public void redirect(ViewEnums target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}
	
	public void include(ViewEnums target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(target.getView()).include(request, response);
	}
	
	/**
	 * Guarda un objeto en la sesion con clave key y valor value
	 * @param session
	 * @param key
	 * @param value
	 */
	public void addAttribute(HttpSession session, Enumerable key, Object value) {
		session.setAttribute(key.toString(), value);		
	}
	
	protected User getUserLogged(HttpServletRequest req) {
		return (User)req.getSession().getAttribute(ViewKeyEnums.USUARIO.name());
	}

	public void addErrorGeneral(HttpServletRequest req, String error) {
		addAttribute(req, ViewKeyEnums.ERROR_GENERAL, error);
	}

	public void addExitoGeneral(HttpServletRequest req, String mensaje) {
		addAttribute(req, ViewKeyEnums.EXITO, mensaje);
	}
}
