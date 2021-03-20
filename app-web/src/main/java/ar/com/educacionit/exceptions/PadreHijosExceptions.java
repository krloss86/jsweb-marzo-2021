package ar.com.educacionit.exceptions;

import ar.com.educacionit.interfaces.IIDioma;
import ar.com.educacionit.interfaces.impl.Espanol;
import ar.com.educacionit.interfaces.impl.Ingles;

public class PadreHijosExceptions {

	public static void main(String[] args) {
		
		IIDioma e = new Espanol();
		IIDioma i = new Ingles();
		
		IIDioma unIdioma = (Espanol)i;
		
		unIdioma.decir("palabra");
	}

}
