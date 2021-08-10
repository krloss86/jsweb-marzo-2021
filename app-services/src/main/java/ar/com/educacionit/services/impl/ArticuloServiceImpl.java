package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.dao.ArticulosDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ArticulosJDBCDaoImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ArticulosService;

public class ArticuloServiceImpl extends AbstractBaseService<Articulos> implements ArticulosService{

	public ArticuloServiceImpl() {
		super(new ArticulosJDBCDaoImpl());
	}

	@Override
	public List<Articulos> findByCategoriaId(Long categoriaId) throws ServiceException {
		try {
			//como no es un metodo del generic, debo castear a ArticulosDao
			return ((ArticulosDao)super.dao).findAllCategoriaId(categoriaId);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

}
