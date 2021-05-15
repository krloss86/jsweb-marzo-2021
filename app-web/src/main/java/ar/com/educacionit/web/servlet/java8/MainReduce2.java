package ar.com.educacionit.web.servlet.java8;

import java.util.ArrayList;
import java.util.List;

public class MainReduce2 {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(-1);
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);

		
		String valoresConcatenados = enteros.stream()
			.map(x -> new String("valor"+x))
			//es una lista de String
			.reduce("", (x,y) -> x+","+y );
			
		System.out.println(valoresConcatenados);	
	}

}
