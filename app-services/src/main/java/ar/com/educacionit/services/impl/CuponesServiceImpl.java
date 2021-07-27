package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.CuponesJDBCDaoImpl;
import ar.com.educacionit.domain.Cupones;
import ar.com.educacionit.services.CuponesService;

public class CuponesServiceImpl extends AbstractBaseService<Cupones> implements CuponesService{

	public CuponesServiceImpl() {
		super(new CuponesJDBCDaoImpl());
	}

}
