package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.ServiceException;

public interface IBaseService<T> {

	public List<T> findAll() throws ServiceException;
	
	public List<T> findAllBy(String criteria) throws ServiceException;
	
	public T getOne(Long id) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;
	
	public void save(T entity) throws DuplicatedException, ServiceException;
	
	public void update(T entity) throws DuplicatedException, ServiceException;
}
