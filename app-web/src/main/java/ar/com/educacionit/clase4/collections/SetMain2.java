package ar.com.educacionit.clase4.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain2 {

	public static void main(String[] args) {
		//crea
		HashSet<Integer> edades = new HashSet<>();

		edades.add(10);
		edades.add(20);
		edades.add(30);		

		//eliminar de uno
		/*for(Integer i : edades) {
			edades.remove(i);
		}*/
		/*
		while(!edades.isEmpty()) {
			edades.remove(edades);
		}*/
		
		//contains
		boolean contiene = edades.contains(40);
		System.out.println("Edades " + (contiene ? "Contiene al 40" : "No contiene al 40" ));
		contiene = edades.contains(30);
		System.out.println("Edades " + (contiene ? "Contiene al 30" : "No contiene al 30" ));
				
		Iterator<Integer> itEdades = edades.iterator();
		while(itEdades.hasNext()) {
			itEdades.next();
			itEdades.remove();
		}
			
		System.out.println("fin");
	}

}
