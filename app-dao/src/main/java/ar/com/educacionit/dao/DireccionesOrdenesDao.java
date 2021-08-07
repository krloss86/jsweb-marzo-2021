package ar.com.educacionit.dao;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.DireccionesOrdenes;

public interface DireccionesOrdenesDao extends GenericDao<DireccionesOrdenes>{

	public DireccionesOrdenes findByOrdenesId(Long ordenesId) throws GenericException;
}
