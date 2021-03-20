package ar.com.educacionit.exceptions;

import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class DivisionCheckedMain3 {

	public static void main(String[] args) {
		
		int a = 10;		
		
		int b = 0;
		
		boolean continuar = true;
		do {
			try {
				Calculadora.dividir(a, b);
				continuar = false;
			}catch (DivisionPorCeroException e) {
				e.printStackTrace();
				b = 1;
			}
		}while(continuar);
	}

}
