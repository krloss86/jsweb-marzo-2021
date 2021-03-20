package ar.com.educacionit.clase1;

public class Programa1 {
	
	public static void main(String[] args) {
		// comentario

		// sumar dos numero y mostar su valor
		
		//definir una VARIBALE
		//tipo y nombre
		int valor1; //definir una variable		
		valor1 = 10; //asignando un valor a la variable valor1
		
		int valor2 = 10;// definir y asignar sintáxis
		
		//operadores MATEMATICOS -,+,*,/, %
		int resultado;		
		resultado = valor1 + valor2;
		
		//----------------
		// estrucura de control de flujo IF/ELSE
		// !
		if ( valor2 != 0) {
			float resDiv = valor1 / valor2;
			System.out.println(resDiv);
		}else {
			System.out.println("No se puede dividir por 0");
		}
	}

}
