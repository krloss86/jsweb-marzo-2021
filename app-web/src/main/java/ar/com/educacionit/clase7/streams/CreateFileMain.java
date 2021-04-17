package ar.com.educacionit.clase7.streams;

import java.io.File;

public class CreateFileMain {

	public static void main(String[] args) {

		File myFyle = new File("C:\\Desarrollo\\educacionit\\files-dat"); 
		
		if(!myFyle.exists()) {
			boolean created = myFyle.mkdir();
			
			if(created) {
				System.out.println("Se ha creado correctamente la carpeta:" + myFyle.getAbsoluteFile());
			}else {
				System.err.println("NO Se ha creado correctamente la carpeta:" + myFyle.getAbsoluteFile());
			}
		}else {
			System.out.println("La carpeta:" + myFyle.getAbsoluteFile() + " ya existe");
		}
	}

}
