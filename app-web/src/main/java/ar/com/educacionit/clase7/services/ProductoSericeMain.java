package ar.com.educacionit.clase7.services;

import java.util.Collection;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

public class ProductoSericeMain {

	public static void main(String[] args) throws ServiceException {

		//ProductoDAO pdao = new ProductoDAOJdbcImpl();
		
		//pdao.findAll();
		
		ProductoServices ps = new ProductoServiceImpl();
		
		Collection<Producto> productos = ps.findAll();
		
		System.out.println(productos);
	}
}
