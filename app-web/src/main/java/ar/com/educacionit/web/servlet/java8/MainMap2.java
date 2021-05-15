package ar.com.educacionit.web.servlet.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMap2 {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);
		
		Integer mayor = 18;
		
		//filtrar
		List<Integer> mayores = enteros.stream()
				.filter(pepe -> pepe > mayor)
				.collect(Collectors.toList());
		
		System.out.println(mayores);
		
		List<String> enterosAString = mayores.stream()
			.map(valorEntrante -> new String("Edad" + valorEntrante))
			.collect(Collectors.toList());
		
		System.out.println(enterosAString);
	}

}
