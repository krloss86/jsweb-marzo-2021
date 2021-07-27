package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Categoria;
import ar.com.educacionit.exceptions.ServiceException;

public interface CategoriasService {

	public List<Categoria> findAll() throws ServiceException;
}
