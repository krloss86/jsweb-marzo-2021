package ar.com.educacionit.services.impl;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
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

	@Override
	public void actualizarProdcuto(Producto producto) throws ServiceException {
		try {
			this.productoDao.update(producto);
		} catch (GenericException e) {			
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Collection<Producto> buscarProductos(String clave) throws ServiceException {
		try {
			return this.productoDao.findAllByTitulo(clave);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Producto eliminarProducto(Long id) throws ServiceException {		
		try {
			return this.productoDao.deleteById(id);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Producto getById(Long id) throws ServiceException {
		try {
			return this.productoDao.getById(id);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Producto nuevoProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.create(producto);
		} catch (DuplicatedException e) {
			throw new ServiceException("Prducto Duplicado: " + e.getMessage(), e);
		} catch (GenericException e) {
			throw new ServiceException("Error interno: " + e.getMessage(), e);
		}
	}
	
	@Override
	public Producto obtenerProductoPorCodigo(String codigo) throws ServiceException {
		try {
			return this.productoDao.getByCodigo(codigo);
		} catch (GenericException e) {			
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
