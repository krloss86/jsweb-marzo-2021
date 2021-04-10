package ar.com.educacionit.clase6.jdbc.menu;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class BuscarPorID extends AccionBase implements IAccion {

	@Override
	public void execute() {
		System.out.println("Ingrese el ID");

		Long id = teclado.nextLong();
				
		try {
			Producto productoPorCodigo = super.pdao.getById(id);
			
			System.out.println(productoPorCodigo);
		} catch (GenericException e) {
			System.err.println("No se ha encontrado el producto con id="+ id);
			System.err.println(e.getMessage());
		} 
	}

}
