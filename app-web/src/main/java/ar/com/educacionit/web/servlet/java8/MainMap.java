package ar.com.educacionit.web.servlet.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMap {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);
		
		Integer mayor = 18;
		
		//filtrar
		List<Integer> mayores = new ArrayList<>();
		for(Integer aux : enteros) {
			if(aux > mayor) {
				mayores.add(mayor);
			}
		}		
		
		System.out.println(mayores);
		
		List<String> enterosAString = new ArrayList<>();
		
		for(Integer aux : mayores) {
			enterosAString.add("Edad " + aux);
		}
				
		System.out.println(enterosAString);
	}

}
