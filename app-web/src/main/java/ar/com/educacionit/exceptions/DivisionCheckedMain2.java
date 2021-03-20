package ar.com.educacionit.exceptions;

import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class DivisionCheckedMain2 {

	public static void main(String[] args) throws DivisionPorCeroException {
		int a = 10;
		int b = 0;		
		Calculadora.dividir(a, b);
		//si no quiero controlar el error con 
		// try/catch, agrgar throws en el método
	}

}
