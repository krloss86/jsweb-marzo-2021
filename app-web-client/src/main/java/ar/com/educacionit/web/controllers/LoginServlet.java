package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Paises;
import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.impl.LoginServiceImp;
import ar.com.educacionit.services.impl.PaisesServiceImpl;
import ar.com.educacionit.web.enums.CarritoKeyEnums;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		
		 ViewEnums target = ViewEnums.LOGIN_SUCCESS;

		 if(!"".equals(username) && !"".equals(password)) {
		 
			 LoginService ls = new LoginServiceImp();
			 
			 try {
				
				User user = ls.getUserByUserName(username);
				
				if(user != null && user.getPassword().equals(password)) {
					//request.setAttribute(ViewKeyEnums.USUARIO.name(), user);
					
					//sesion!
					addAttribute(request.getSession(), ViewKeyEnums.USUARIO, user);
					
					List<Paises> paises = new PaisesServiceImpl().findAll();
					addAttribute(request.getSession(), CarritoKeyEnums.PAISES, paises);
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
			 
		 }else {
			 request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), ViewKeyEnums.USUARIO_PASSWORD_INVALIDO.getViewKey());
			 target = ViewEnums.LOGIN;
		 }
		 
		 //redireccion!!!
		 
		 RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getView());		
		 rd.forward(request, response);
	}

}
