package ar.com.educacionit.clase6.jdbc.menu;

import java.util.Collection;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class ListarTodos extends AccionBase implements IAccion {

	@Override
	public void execute() {
		
		//acá va la lógica
		try {
			Collection<Producto> productos = super.pdao.findAll();
			if(!productos.isEmpty()) {
				System.out.println("Se han encontrado: " + productos.size() + " productos");
				System.out.println(productos);
			}else {
				System.out.println("No se han encontrado productos");	
			}
		} catch (GenericException e) {
			e.printStackTrace();
		}
	}

}
