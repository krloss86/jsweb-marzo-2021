package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.IIDioma;

public class Espanol implements IIDioma {

	@Override
	public void decir(String palabra) {
		System.out.println("En español: " + palabra);
	}

}
