package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.IIDioma;

public class Ingles implements IIDioma {

	@Override
	public void decir(String palabra) {
		System.out.println("In English: " + palabra);
	}

}
