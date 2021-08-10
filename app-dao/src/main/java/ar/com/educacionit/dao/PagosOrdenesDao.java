package ar.com.educacionit.dao;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.PagosOrdenes;

public interface PagosOrdenesDao extends GenericDao<PagosOrdenes>{

	public PagosOrdenes findByOrdenesId(Long ordenesId) throws GenericException;
}
