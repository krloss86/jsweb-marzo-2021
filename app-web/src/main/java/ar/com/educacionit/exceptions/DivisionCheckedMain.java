package ar.com.educacionit.exceptions;

import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class DivisionCheckedMain {

	//indicando que este metodo lanza un DivisionPorCeroException
	public static void main(String[] args) throws DivisionPorCeroException{
		int valor1 = 10;
		int valor2 = 0;
		
		int res;
		if(valor2 ==0) {
			//creando y lanzando
			throw new DivisionPorCeroException("No se puede dividir por 0", null); 
		}		
		
		res = valor1 / valor2;
		System.out.println(res);

	}

}
