package ar.com.educacionit.clase7.streams;

import java.io.File;

public class ListFileMain {

	public static void main(String[] args) {

		//raiz
		File myFyle = new File("C:\\Desarrollo\\educacionit\\files-dat"); 
		
		if(myFyle.exists()) {
			
			if(myFyle.isDirectory()) { 
				
				File[] files = myFyle.listFiles();
				
				listFileNames(files);				
			}
			
		}else {
			System.err.println("La carpeta:" + myFyle.getAbsoluteFile() + " no existe");
		}
	}

	//metodo recursivo
	private static void listFileNames(File[] files) {
		
		if(files == null || files.length == 0) {
			return;
		}
		
		//caso base
		for(File aux : files) {
			
			if(aux.isDirectory()) {
				
				File[] filesInDirectory = aux.listFiles();
				
				//invoco a la misma funcion
				listFileNames(filesInDirectory);
			}else {
				System.out.println(aux.getName());
			}			
		}		
	}

}
