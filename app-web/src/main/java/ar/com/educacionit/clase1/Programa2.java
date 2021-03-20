package ar.com.educacionit.clase1;

public class Programa2 {

	public static void main(String[] args) {
		
		//operadores relacionales
		//< , > , ==, !=
		
		//a > b
		//10 >5 -> true
		
		float alturaMia = 174; 
		float otraAltura = 174.1f;
		//por defecto en java los valores con decimales don "double"
		double alturaX = 174.1;
		
		/*
		if(  ) {
			//mi codigo
		}else if() {
			//codigo del elseif
		} else {
			// codigo del else
		}
		*/
		
		if(alturaMia > otraAltura) {
			System.out.println("Soy mas alto");
		}else if(alturaMia == otraAltura) {
			System.err.println("Somos de la misma altura");
		}else {
			System.out.println("Soy mas bajo");
		}
	}

}
