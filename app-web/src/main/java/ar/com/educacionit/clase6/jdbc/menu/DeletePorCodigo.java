package ar.com.educacionit.clase6.jdbc.menu;

import java.util.InputMismatchException;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class DeletePorCodigo extends AccionBase implements IAccion {

	@Override
	public void execute() {

		Integer codigo = null;
		
		do {
			System.out.println("Ingrese el CODIGO de producto a eliminar");
			try {
				codigo = teclado.nextInt();			
			}catch (InputMismatchException e) {
				System.err.println("Codigo inválido" );
				teclado.next();
				continue;
			}
		}while(codigo == null);
				
		try {
			Producto productoPorCodigo = super.pdao.deleteByCodigo(codigo.toString());
			
			System.out.println("Se ha eliminado el producto: "+ productoPorCodigo);
		} catch (GenericException e) {
			System.err.println("No se ha encontrado el producto con CODIGO="+ codigo);
			System.err.println(e.getMessage());
		} 
	}

}
