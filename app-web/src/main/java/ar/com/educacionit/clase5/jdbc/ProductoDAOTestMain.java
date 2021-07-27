package ar.com.educacionit.clase5.jdbc;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class ProductoDAOTestMain {

	public static void main(String[] args) throws GenericException {
		
		ProductoDao pdao = new ProductoDAOJdbcImpl();
		
		Collection<Producto> products = pdao.findAll();

		System.out.println(products);
	}

}
