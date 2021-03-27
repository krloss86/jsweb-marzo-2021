package ar.com.educacionit.clase4.generics;

public abstract class ClaseBase<T> {

	private String saludo;
	
	public ClaseBase(String saludo) {
		this.saludo = saludo;
	}
	
	public void saludar() {
		System.out.println(saludo);
	}
	
	public abstract T crearAlgo();
}
