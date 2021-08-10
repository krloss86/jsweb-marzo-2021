package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.ServiceException;

public interface ArticulosService extends GenericService<Articulos>{

	public List<Articulos> findByCategoriaId(Long categoriaId) throws ServiceException;
}
