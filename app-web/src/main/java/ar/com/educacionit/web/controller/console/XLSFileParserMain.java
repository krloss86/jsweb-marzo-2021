package ar.com.educacionit.web.controller.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServiceImpl;
import ar.com.educacionit.web.parser.CSVFileParser;
import ar.com.educacionit.web.parser.IFileParser;
import ar.com.educacionit.web.parser.XLSFileParser;

public class XLSFileParserMain {

	public static void main(String[] args) throws IOException {
		
		String fileName = "C:\\Desarrollo\\educacionit\\files\\nuevos-productos.csv";

		String ext = getExt(fileName);
				
		IFileParser fileParser;
		
		if("csv".equals(ext.toLowerCase())) {
			fileParser = new CSVFileParser(fileName);			
		}else {
			fileParser = new XLSFileParser(fileName);
		}
		
		Collection<Producto> productos = fileParser.parse(); 
		
		Collection<Producto> ok = new ArrayList<>();
		Map<String,Producto> fail= new HashMap<>();
		
		if(!productos.isEmpty()) {
			
			ProductoServices ps = new ProductoServiceImpl();
			
			for(Producto aux : productos) {
				
				try {
					Producto product = ps.nuevoProducto(aux);
					ok.add(product);
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

	/**
	 * OJO VALIDAR QUE FILE NAME SEA != NULL
	 * @param fileName
	 * @return
	 */
	private static String getExt(String fileName) {
		
		int from = fileName.lastIndexOf(".") + 1;
		
		return fileName.substring(from, fileName.length());		
	}

}
