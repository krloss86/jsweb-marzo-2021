package ar.com.educacionit.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.impl.LoginServiceImp;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		
		 LoginService ls = new LoginServiceImp();
		 
		 ViewEnums target = ViewEnums.LOGIN_SUCCESS;
		 
		 try {
			
			User user = ls.getUserByUserName(username);
			
			if(user != null) {
				//verifico la password
				BCrypt.Result result = BCrypt.verifyer().verify(password.getBytes(), user.getPassword().getBytes());					
			
				if(result.verified) {

					//sesion!
					request.getSession().setAttribute(ViewKeyEnums.USUARIO.name(), user);
				}else {
					request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), ViewKeyEnums.USUARIO_PASSWORD_INVALIDO.getViewKey());
					target = ViewEnums.LOGIN;
				}
			}else {
				request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), ViewKeyEnums.USUARIO_PASSWORD_INVALIDO.getViewKey());
				target = ViewEnums.LOGIN;
			}
			
		} catch (ServiceException e) {
			/*String msjError = e.getMessage();
			if(e.getCause() != null) {
				msjError += " - " + e.getMessage();
			}*/
			request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), e.getMessage());
			target = ViewEnums.LOGIN;
		}
		 
		//redireccion!!!
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getView());		
		rd.forward(request, response);
	}

}
