package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.EstadosOrdenesJDBCDaoImpl;
import ar.com.educacionit.domain.EstadosOrdenes;
import ar.com.educacionit.services.EstadosOrdenesService;

public class EstadosOrdenesServiceImpl extends AbstractBaseService<EstadosOrdenes> implements EstadosOrdenesService{

	public EstadosOrdenesServiceImpl() {
		super(new EstadosOrdenesJDBCDaoImpl());
	}

}
