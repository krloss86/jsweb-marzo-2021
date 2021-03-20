package ar.com.educacionit.clase3.laboratorio;

import java.util.Scanner;

public class DataEntry {

	public static Persona[] cargarPersonas() {
		Persona[] personas = new Persona[0];
		
		Scanner teclado = new Scanner(System.in);
		
		Integer cantidad;
		do {
			System.out.println("Ingrese cantidad de personas:");
			cantidad = teclado.nextInt();
		}while(cantidad < 0 || cantidad > 10);

		for(int i=0; i< cantidad; i++) {
			personas = new Persona[cantidad];
			
			System.out.println("Ingrese Nombre:");
			String nombre = teclado.next();
			
			System.out.println("Ingrese Apellido:");
			String apellido = teclado.next();
			
			personas[i] = new Persona(nombre, apellido);
		}
	
		teclado.close();
		return personas;
	}
	
}
