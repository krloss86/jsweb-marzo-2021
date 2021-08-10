package ar.com.educacionit.web.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;

public class CSVFileParser extends FileParserBase implements IFileParser {

	public CSVFileParser(Part filePart) {
		super(filePart);
	}
	
	
	public CSVFileParser(String name) {
		super(name);
	}

	@Override
	public Collection<Articulos> parse() throws IOException {
		
		BufferedReader br = null;
		
		if(this.filePart != null) {
			InputStream fileContent = filePart.getInputStream();
			br = new BufferedReader(new InputStreamReader(fileContent));
		}else {
		
			File myFyle = new File(super.name);
			
			if(myFyle.exists()) {
				FileReader fr = new FileReader(myFyle);
				br = new BufferedReader(fr);
			}
		}
		
		Collection<Articulos> productos = new ArrayList<Articulos>();
		
		if(br != null) {
			productos = this.buildArticulos(br);
		}
		
		return productos;
	}


	private Collection<Articulos> buildArticulos(BufferedReader fr) throws IOException {
		
		Collection<Articulos> productos = new ArrayList<Articulos>();
		
		String lineaLeida = fr.readLine();
		// titulo;codigo;precio;tipo
		
		while(lineaLeida  != null) {
			
			lineaLeida = fr.readLine();
			//teclado;abc999;1500;1
			if(lineaLeida !=null) {
				//separo por ;
				String[] datos = lineaLeida.split(";");
				
				if(datos.length > 1 && !"".equals(datos[0])) {
					String titulo = datos[0];
					String codigo = datos[1];
					Double precio = Double.parseDouble(datos[2]);
					Long stock = Long.parseLong(datos[3]);
					Long categoria = Long.parseLong(datos[4]);
					Long marca = Long.parseLong(datos[5]);
					
					Articulos articulo = new Articulos(titulo, codigo, precio, stock,marca, categoria);
					
					productos.add(articulo);
				}
			}
		}
		
		fr.close();
		
		return productos;
	}

}
