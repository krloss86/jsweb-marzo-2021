package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.GenericService;

public class AbstractBaseService<T> implements GenericService<T> {

	protected GenericDao<T> dao;
	
	protected AbstractBaseService(GenericDao<T> dao) {
		this.dao = dao;
	}
	
	@Override
	public List<T> findAll() throws ServiceException {
		try {
			return this.dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido consultar todos", e); 
		}
	}

	@Override
	public List<T> findAllBy(String criteria) throws ServiceException {
		try {
			return this.dao.findAllBy(criteria);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido consultar todos", e); 
		}
	}

	@Override
	public T getOne(Long id) throws ServiceException {
		try {
			return this.dao.getOne(id);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido realizar la consulta", e);
		}
	}

	@Override
	public void delete(Long id) throws ServiceException {
		try {
			this.dao.delete(id);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido eliminar", e);
		}		
	}

	@Override
	public void save(T entity) throws ServiceException {
		try {
			this.dao.save(entity);
		} catch (DuplicatedException e) {
			throw new ServiceException("Entidad duplicada " + entity.getClass().getSimpleName() , e);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido grabar " + entity.getClass().getSimpleName() , e);
		}
		
	}

	@Override
	public void update(T entity) throws ServiceException {
		try {
			this.dao.update(entity);
		} catch (DuplicatedException e) {
			throw new ServiceException("Entidad duplicada " + entity.getClass().getSimpleName() , e);
		} catch (GenericException e) {
			throw new ServiceException("No se ha podido actualizar" + entity.getClass().getSimpleName() , e);
		}
	}

}
