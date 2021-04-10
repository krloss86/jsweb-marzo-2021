package ar.com.educacionit.clase6.jdbc;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class DeleteProductoCodigoIDMain {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el CODIGO de producto a eliminar");

		String codigo = teclado.next();
		
		ProductoDAO productoDao = new ProductoDAOJdbcImpl();
		
		try {
			Producto productoPorCodigo = productoDao.deleteByCodigo(codigo);
			
			System.out.println("Se ha eliminado el producto: "+ productoPorCodigo);
		} catch (GenericException e) {
			System.err.println("No se ha encontrado el producto con CODIGO="+ codigo);
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
	}

}
