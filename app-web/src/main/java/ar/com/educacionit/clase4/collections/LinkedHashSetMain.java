package ar.com.educacionit.clase4.collections;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetMain {

	public static void main(String[] args) {
		
		LinkedHashSet<String> nombres = new LinkedHashSet<>();
		
		nombres.add("Fernando");
		nombres.add("Francisco");
		nombres.add("Leonardo");
		nombres.add("Sebastian");
		nombres.add("Oliden");
		
		nombres.remove("Sebastian");
		
		Iterator<String> itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
			String nombre = itNombres.next();
			System.out.println(nombre);
		}

	}

}
