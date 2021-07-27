package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.OrdenesJDBCDaoImpl;
import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.services.OrdenesService;

public class OrdenesServiceImpl extends AbstractBaseService<Ordenes> implements OrdenesService{

	public OrdenesServiceImpl() {
		super(new OrdenesJDBCDaoImpl());
	}

}
