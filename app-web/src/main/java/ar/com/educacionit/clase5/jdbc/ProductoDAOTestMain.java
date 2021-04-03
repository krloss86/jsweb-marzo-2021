package ar.com.educacionit.clase5.jdbc;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class ProductoDAOTestMain {

	public static void main(String[] args) throws GenericException {
		
		ProductoDAO pdao = new ProductoDAOJdbcImpl();
		
		Collection<Producto> products = pdao.findAll();

		System.out.println(products);
	}

}
