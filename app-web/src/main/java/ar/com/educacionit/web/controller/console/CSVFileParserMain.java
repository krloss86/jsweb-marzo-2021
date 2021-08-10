package ar.com.educacionit.web.controller.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.services.impl.ProductoServiceImpl;
import ar.com.educacionit.web.parser.CSVFileParser;
import ar.com.educacionit.web.parser.IFileParser;

public class CSVFileParserMain {

	public static void main(String[] args) throws IOException {
		
		String fileName = "C:\\Desarrollo\\educacionit\\files\\nuevos-productos.csv";

		IFileParser fileParser = new CSVFileParser(fileName);
		
		Collection<Articulos> productos = fileParser.parse(); 
		
		Collection<Articulos> ok = new ArrayList<>();
		Map<String,Articulos> fail= new HashMap<>();
		
		if(!productos.isEmpty()) {
			
			ArticulosService ps = new ArticuloServiceImpl();
			
			for(Articulos aux : productos) {
				
				try {
					ps.save(aux);
					ok.add(aux);
				} catch (ServiceException e) {
					//fail.add(aux);
					fail.put(e.getCause().getMessage(), aux);
				}
			}
			
			System.out.println("Se han procesado :" + ok.size() + " exitosamente");
			System.err.println("Se han procesado :" + fail.size() + " con errores");
		}
		
		//si hay errores crear un archivo para esos productos
		
		IFileWritter fileWritter = new ProductoWritter();
		fileWritter.write("C:\\Desarrollo\\educacionit\\files\\productos-error.csv", fail);
	}

}
