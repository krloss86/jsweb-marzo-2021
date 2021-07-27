package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.PaisesJDBCDaoImpl;
import ar.com.educacionit.domain.Paises;
import ar.com.educacionit.services.PaisesService;

public class PaisesServiceImpl extends AbstractBaseService<Paises> implements PaisesService{

	public PaisesServiceImpl() {
		super(new PaisesJDBCDaoImpl());
	}

}
