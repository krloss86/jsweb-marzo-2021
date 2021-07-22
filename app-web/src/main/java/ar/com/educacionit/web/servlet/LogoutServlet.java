package ar.com.educacionit.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ViewEnums;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//mata la sesion
		request.getSession().invalidate();
		
		redirect(ViewEnums.LOGIN, request, response);
	}

}
