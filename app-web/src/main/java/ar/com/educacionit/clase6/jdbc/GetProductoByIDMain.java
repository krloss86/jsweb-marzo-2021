package ar.com.educacionit.clase6.jdbc;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class GetProductoByIDMain {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el ID");

		Long id = teclado.nextLong();
		
		ProductoDao productoDao = new ProductoDAOJdbcImpl();
		
		try {
			Producto productoPorCodigo = productoDao.getById(id);
			
			System.out.println(productoPorCodigo);
		} catch (GenericException e) {
			System.err.println("No se ha encontrado el producto con id="+ id);
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
	}

}
