package ar.com.educacionit.clase7.streams;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileMain {

	public static void main(String[] args) throws IOException {
		
		File myFyle = new File("C:\\Desarrollo\\educacionit\\files-dat\\1.txt");
		
		//abro 
		FileReader fr = new FileReader(myFyle);

		int letra;
		
		//mientras existan dato
		while((letra = fr.read()) != -1) {
			
			//leo
			//System.out.println(letra);
			System.out.print((char)letra);
		}
		
		//cerrar archivo/lector 
		fr.close();
	}

}
