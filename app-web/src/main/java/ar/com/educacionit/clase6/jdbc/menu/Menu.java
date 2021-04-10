package ar.com.educacionit.clase6.jdbc.menu;

import java.util.Scanner;

public class Menu {

	public void mostrarMenu() {
		System.out.println("Ingrese una opcion:");
		System.out.println("1 - Crear");
		System.out.println("2 - Buscar Por Id");
		System.out.println("3 - Buscar Por Código");
		System.out.println("4 - Actualizar");
		System.out.println("5 - Elimiar Por Id");
		System.out.println("6 - Eliminar Por Codigo");
		System.out.println("7 - Listar Todos");
		System.out.println("8 - Buscar Por Título");		
	}

	public Integer getObtenerOpcion(Scanner teclado) {
		Integer opcion = null;
		do {
			this.mostrarMenu();
			opcion = teclado.nextInt();
		}while(opcion < 0 || opcion > 8);
		
		return opcion;
	}
}
