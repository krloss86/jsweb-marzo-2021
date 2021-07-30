package ar.com.educacionit.clase6.jdbc.menu;

import ar.com.educacionit.dao.ProductoDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class UpdateProducto extends AccionBase implements IAccion {

	@Override
	public void execute() {
		System.out.println("Ingrese el ID de producto que desea actualizar");

		Long id = teclado.nextLong();
		
		ProductoDao productoDao = new ProductoDAOJdbcImpl();
		
		try {
			Producto producto = productoDao.getById(id);
			
			System.out.println("Se actualizará el siguiente producto:");
			System.out.println(producto);
			
			if(producto != null) {

				//precio
				System.out.println("Ingrese el nuevo Precio");
				Double precioActualizado = teclado.nextDouble();				
				producto.setPrecio(precioActualizado);
				
				//titulo
				System.out.println("Ingrese el nuevo Título");
				String nuevoTitulo = teclado.next();
				producto.setTitulo(nuevoTitulo);
				
				producto = productoDao.update(producto);
				System.out.println("Producto actualizado correctamente");
			}else {
				System.err.println("No existe el producto id=" + id);
			}			
		}catch (GenericException e) {
			System.err.println(e.getMessage());
		} 
	}

}
