package ar.com.educacionit.dao;

import java.util.List;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;

public interface ArticulosDao extends GenericDao<Articulos>{
	
	/**
	 * Consulta articulos por una condiciones
	 * @return
	 * @throws GenericException 
	 */
	public List<Articulos> findAllBy(String titulo) throws GenericException;
	
	public List<Articulos> findAllCategoriaId(Long categoriaId) throws GenericException;
}
