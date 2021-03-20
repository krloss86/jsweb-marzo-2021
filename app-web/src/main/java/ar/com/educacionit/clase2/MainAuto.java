package ar.com.educacionit.clase2;

public class MainAuto {

	public static void main(String[] args) {
		
		// como instanciar un objeto de la clase Auto
			
		Auto auto1 = new Auto();
		
		Auto auto3 = new Auto("renautl","duster","rojo",270);
		
		//ahora que está vivo
		auto1.encender();
		System.out.println("----------------------------------");
		auto1.informarEstado();
		System.out.println("----------------------------------");
		auto1.acelerar();
		System.out.println("----------------------------------");
		auto1.informarEstado();
		System.out.println("----------------------------------");				
		auto3.encender();
		System.out.println("----------------------------------");
		auto3.informarEstado();
	}

}
