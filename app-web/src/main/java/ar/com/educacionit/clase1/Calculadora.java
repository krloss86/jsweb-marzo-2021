package ar.com.educacionit.clase1;

public class Calculadora {

	public static void main(String[] args) {
	
		//suma
		int a = 10;
		
		int b = 20;
		
		int c = sumar(a,b);
		System.out.println(c);
		
		c = a-b;
		System.out.println(c);
		
		float division = dividir(a, b);
		System.out.println(c);		
	}

	static int sumar(int a, int b) {
		return a+b;
	}
	static float dividir(int a, int b) {
		if(b !=0) {
			return a / b;
		}else {
			System.err.println("No se puede dividir por 0");
			return -0;
		}
	}
}
