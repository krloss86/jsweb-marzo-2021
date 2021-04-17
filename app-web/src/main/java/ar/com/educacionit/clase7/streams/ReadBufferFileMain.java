package ar.com.educacionit.clase7.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadBufferFileMain {

	public static void main(String[] args) throws IOException {
		
		File myFyle = new File("C:\\Desarrollo\\educacionit\\files-dat\\1.txt");
		
		Reader r = new FileReader(myFyle);
		
		BufferedReader bf = new BufferedReader(r);
		
		String linea;
		
		while((linea = bf.readLine()) != null) {
			System.out.println(linea);
		}
		
		bf.close();
	}

}
