package ar.com.educacionit.clase6.jdbc.menu;

import java.util.Scanner;

public class MenuMain {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		Menu menu = new Menu();
		
		Integer continuar = null;
		
		do {
			Integer opcion = menu.getObtenerOpcion(teclado);
				
			MenuEnum menuEnum = MenuEnum.getByCodigo(opcion);
	
			IAccion accion = MenuAccionFactory.getIAccion(menuEnum);
			//down casting
			((AccionBase)accion).setTeclado(teclado);
			
			accion.execute();
			System.out.println("-----------------------------");
			System.out.println("Desea continuar (1=SI; 0=NO)");
			continuar = teclado.nextInt();					
		}while(continuar == 1);
		
		teclado.close();
	}

}
