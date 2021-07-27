package ar.com.educacionit.clase6.jdbc;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class UpdateProductoMain {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el ID de producto que desea actualizar");

		Long id = teclado.nextLong();
		
		ProductoDao productoDao = new ProductoDAOJdbcImpl();
		
		try {
			Producto producto = productoDao.getById(id);
			
			if(producto != null) {
				System.out.println(producto);
				//precio en un 10%
				Float precioActual = producto.getPrecio();
				Float precioActualizado = precioActual * 1.1f;
				producto.setPrecio(precioActualizado);
				
				//titulo
				producto.setTitulo(producto.getTitulo().toUpperCase());
				
				producto = productoDao.update(producto);
				System.out.println(producto);
				System.out.println("Producto actualizado correctamente");
			}else {
				System.err.println("No existe el producto id=" + id);
			}			
		}catch (GenericException e) {
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
	}

}
