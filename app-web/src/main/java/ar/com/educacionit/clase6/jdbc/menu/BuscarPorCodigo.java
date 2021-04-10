package ar.com.educacionit.clase6.jdbc.menu;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class BuscarPorCodigo extends AccionBase implements IAccion {

	@Override
	public void execute() {
		System.out.println("Ingrese el Código");

		String codigo = teclado.next();
		
		ProductoDAO productoDao = new ProductoDAOJdbcImpl();
		
		try {
			Producto productoPorCodigo = productoDao.getByCodigo(codigo);
			
			System.out.println(productoPorCodigo);
		} catch (GenericException e) {
			System.err.println("No se ha encontrado el producto con codigo="+ codigo);
			System.err.println(e.getMessage());
		} 
	}

}
