package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.IIDioma;

public class Chino implements IIDioma {

	@Override
	public void decir(String palabra) {
		System.out.println("En chino: " + palabra);
	}

}
