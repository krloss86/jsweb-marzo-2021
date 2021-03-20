package ar.com.educacionit.interfaces.main;

import ar.com.educacionit.interfaces.IIDioma;
import ar.com.educacionit.interfaces.entidades.Persona;
import ar.com.educacionit.interfaces.impl.Espanol;
import ar.com.educacionit.interfaces.impl.Ingles;

public class MainIdiomas {

	public static void main(String[] args) {
		
		Persona carlos = new Persona("carlos", "lopez", new Espanol());
		
		carlos.decir("hola");
		
		IIDioma ingles =  new Ingles();
		carlos.aprender(ingles);
		
		carlos.decir("hola", ingles);
		
	}

}
