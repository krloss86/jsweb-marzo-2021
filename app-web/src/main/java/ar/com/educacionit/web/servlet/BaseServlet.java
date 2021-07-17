package ar.com.educacionit.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

public abstract class BaseServlet extends HttpServlet {

	protected ProductoServices ps = new ProductoServiceImpl();
	
	//metodos
	public static void addAttribute(HttpServletRequest request, ViewKeyEnums key, Object value ) {
		request.setAttribute(key.name(), value);
	}
	
	public static void addAttribute(HttpServletRequest request, ViewEnums key, Object value ) {
		request.setAttribute(key.name(), value);
	}
	
	public void redirect(ViewEnums target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}
	
	/**
	 * Guarda un objeto en la sesion con clave key y valor value
	 * @param session
	 * @param key
	 * @param value
	 */
	public void addAttribute(HttpSession session, ViewKeyEnums key, Object value) {
		session.setAttribute(key.name(), value);		
	}
}