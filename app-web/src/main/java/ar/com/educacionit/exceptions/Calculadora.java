package ar.com.educacionit.exceptions;

import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class Calculadora {

	public static int dividir(int a, int b) throws DivisionPorCeroException {
		if(b ==0) {
			throw new DivisionPorCeroException("No se puede dividir por 0", null); 
		}				
		return a / b;
	}
}
