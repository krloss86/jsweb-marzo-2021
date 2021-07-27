package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.ArticulosJDBCDaoImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;

public class ArticuloServiceImpl extends AbstractBaseService<Articulos> implements ArticulosService{

	public ArticuloServiceImpl() {
		super(new ArticulosJDBCDaoImpl());
	}

}
