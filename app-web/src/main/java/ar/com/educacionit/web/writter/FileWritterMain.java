package ar.com.educacionit.web.writter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileWritterMain {

	public static void main(String[] args) throws IOException {
		List<String> mensajes = Arrays.asList("linea1","line2","linea3");		
		
		//abril
		File file = new File("C:\\Desarrollo\\educacionit\\files\\fail.csv");
		
		FileWriter fr = new FileWriter(file);
		
		//si hay datos
		for(String aux : mensajes ) {
			//escribir
			fr.write(aux);
			fr.write("\n");
		}
		
		fr.close();
	}

}
