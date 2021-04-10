package ar.com.educacionit.services.impl;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;

public class ProductoServiceImpl implements ProductoServices {

	private ProductoDAO productoDao;
	
	//C.D.I
	//I.O.C
	public ProductoServiceImpl() {
		this.productoDao = new ProductoDAOJdbcImpl();
	}

	@Override
	public Collection<Producto> findAll() throws ServiceException{
		try {
			return this.productoDao.findAll();
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
