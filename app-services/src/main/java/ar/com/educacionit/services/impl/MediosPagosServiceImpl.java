package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.MediosPagosJDBCDaoImpl;
import ar.com.educacionit.domain.MediosPagos;
import ar.com.educacionit.services.MediosPagosService;

public class MediosPagosServiceImpl extends AbstractBaseService<MediosPagos> implements MediosPagosService{

	public MediosPagosServiceImpl() {
		super(new MediosPagosJDBCDaoImpl());
	}

}
