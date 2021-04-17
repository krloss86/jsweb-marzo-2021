package ar.com.educacionit.clase7.streams;

import java.io.File;

public class FileMain {

	public static void main(String[] args) {

		File myFyle = new File("C:\\Desarrollo\\educacionit\\files\\imagen.dat"); 
		
		boolean isDirectory = myFyle.isDirectory();

		if(isDirectory) {
			File[] files = myFyle.listFiles();
			
			for(File aux : files) {
				System.out.println(aux.getName());
			}
		}else {
			if(myFyle.isFile()) {
				System.out.println(myFyle.getName());
			}
		}
	}

}
