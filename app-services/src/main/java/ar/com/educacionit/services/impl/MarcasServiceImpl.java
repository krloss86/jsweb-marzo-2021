package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.MarcasJDBCDaoImpl;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.MarcasService;

public class MarcasServiceImpl extends AbstractBaseService<Marcas> implements MarcasService{

	public MarcasServiceImpl() {
		super(new MarcasJDBCDaoImpl());
	}

}
