package ar.com.educacionit.clase6.services;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

public class ProductoServiceMain {

	public static void main(String[] args) {
		
		ProductoServices ps = new ProductoServiceImpl();
		
		try {
			Collection<Producto> pds =  ps.findAll();
			System.out.println(pds);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
