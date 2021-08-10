package ar.com.educacionit.web.controller.console;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import ar.com.educacionit.domain.Articulos;

public class ProductoWritter implements IFileWritter {

	@Override
	public void write(String name, Map<String, Articulos> productos) throws IOException {
		//abril
		File file = new File(name);
		
		FileWriter fr = new FileWriter(file);
		
		//titulo
		fr.write("titulo;codigo;precio;tipo;motivo\n");
		//si hay datos
		
		Set<Map.Entry<String, Articulos>> entries = productos.entrySet();
		
		for(Map.Entry<String, Articulos> aux : entries) {
			//escribir
			fr.write(toCSV(aux.getValue()) + ";"+aux.getKey());
			fr.write("\n");
		}
		
		fr.close();
	}
	
	
}
