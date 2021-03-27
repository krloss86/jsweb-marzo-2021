package ar.com.educacionit.clase4.collections;

import java.util.HashSet;

public class SetMain {

	public static void main(String[] args) {
		
		//crea
		HashSet<Integer> edades = new HashSet<>();

		//cargar
		boolean agrego = edades.add(1);
		
		if(agrego) {
			System.out.println("1 agregado");
		}
		
		agrego = edades.add(1);
		
		if(agrego) {
			System.out.println("1 agregado");
		}else {
			System.out.println("1 no se agregó");
		}
		
		//agregar varias edades
		
		edades.add(10);
		edades.add(20);
		edades.add(30);
		
		//recorreo un set
		for(Integer edad : edades) {
			System.out.println(edad);
		}
		
		//cantidad de elementos
		System.out.println("Hay " + edades.size() + " edades");
		
		//eliminar un elemento
		boolean elimino = edades.remove(30);
		System.out.println("30 " + (elimino ? " se ha elminado" : " no se ha elimindo"));
		
		System.out.println("Hay " + edades.size() + " edades");
		
		//vaciar el set 
		edades.clear();
		
		System.out.println("Hay " + edades.size() + " edades");
		
		System.out.println("Fin");
	}

}
