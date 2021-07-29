package ar.com.educacionit.dao;

import java.util.List;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;

public interface GenericDao<T> {

	// public List<T> findAll(T entity);
	
	public List<T> findAll() throws GenericException;
	
	public List<T> findAllBy(String criteria) throws GenericException;
	
	public T getOne(Long id) throws GenericException;
	
	public void delete(Long id) throws GenericException;
	
	public void save(T entity) throws DuplicatedException, GenericException;
	
	public void update(T entity) throws DuplicatedException, GenericException;
}
