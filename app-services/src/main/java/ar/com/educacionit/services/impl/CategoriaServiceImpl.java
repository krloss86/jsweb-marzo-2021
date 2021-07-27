package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.dao.CategoriasDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.CategoriaJDBCDaoImpl2;
import ar.com.educacionit.domain.Categoria;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.CategoriasService;

public class CategoriaServiceImpl implements CategoriasService {

	private CategoriasDao dao;
	
	public CategoriaServiceImpl() {
		//this.dao = new CategoriaJDBCDaoImpl();
		this.dao = new CategoriaJDBCDaoImpl2();
	}
	
	@Override
	public List<Categoria> findAll() throws ServiceException {		
		try {
			return this.dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException(e);
		}
	}

}
