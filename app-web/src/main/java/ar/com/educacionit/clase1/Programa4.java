package ar.com.educacionit.clase1;

public class Programa4 {

	public static void main(String[] args) {
		//vectores
		
		// 13 variables de tipo string
		String carlos = "carlos";
		String analia = "analia";		
		String mariano = "mariano";
				
		//defino un vector/array de String
		String[] alumnos;
		
		alumnos = new String[] {carlos, analia, mariano};
		
		//recorrer un vector
		for (int i=0; i < alumnos.length ; i++) {
			System.out.println(alumnos[i]);
		}
		//---------------------
		boolean[] mayores20 = new boolean[6];
		//f5, f6, f7, f8
		//for each
		for( boolean aux : mayores20 ) {
			aux = true;
		}
		for (int i=0; i < mayores20.length ; i++) {
			mayores20[i] = true;
		}
				
		boolean[] mayores40 = new boolean[3];
		
		
	}

}
