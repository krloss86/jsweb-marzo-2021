package ar.com.educacionit.clase6.jdbc;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class CreateProductoMain {

	public static void main(String[] args) {
		//productos?
		//id, titulo, precio, codigo, tipo_producto 

		Scanner teclado = new Scanner(System.in);
		
		//crear producto
		System.out.println("Ingrese titulo:");
		String titulo = teclado.next();
		
		//evitar validaciones
		System.out.println("Ingrese Precio:");
		Float precio = teclado.nextFloat();
		
		System.out.println("Ingrese Código");
		String codigo = teclado.next();
		
		System.out.println("Ingrese Tipo Producto");
		Long tipoProducto = teclado.nextLong();

		// Interface nombre = new Clase();
		ProductoDAO productoDao = new ProductoDAOJdbcImpl();
		
		//creo el producto
		Producto nuevoProducto = new Producto(titulo, precio, codigo, tipoProducto);
		
		try {
			nuevoProducto = productoDao.create(nuevoProducto);// viene con el ID
			System.out.println("Se ha creado el producto: ID="+nuevoProducto.getId());
		} catch (DuplicatedException e) {
			System.err.println(e.getMessage());
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
	}

}
