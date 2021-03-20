package ar.com.educacionit.interfaces;

public interface ILogger {

	//definir el contrato
	public void log();
	
	public default void log1() {
		System.out.println("hola soy el metodo por defecto de ILogger");
	}
	
}
