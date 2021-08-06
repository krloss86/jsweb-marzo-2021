package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Categoria;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.CategoriasService;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.web.enums.CategoriaKeyEnum;
import ar.com.educacionit.web.enums.ViewEnums;

@WebServlet("/controllers/categoria")
public class CategoriaControllers extends BaseServlet {

	private final static CategoriasService categoriasService = new CategoriaServiceImpl();
	
	private static final long serialVersionUID = -4676049283383295869L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Categoria> list;
		try {
			
			list = categoriasService.findAll();
			
			super.addAttribute(req, CategoriaKeyEnum.LIST_CATEGORIAS, list);
			
		} catch (ServiceException e) {
			//list = new ArrayList<Categoria>();
			throw new IOException(e.getCause().getMessage(),e);
		}
		
		redirect(ViewEnums.LISTADO_CATEGORIAS_INDEX, req, resp);		
	}
}
