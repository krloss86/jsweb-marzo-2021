package ar.com.educacionit.web.servlet.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainReduce {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(-1);
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);
		
		Integer suma = 0;
		
		for(Integer aux : enteros) {
			//suma = suma + aux;
			suma += aux;
		}
		
		System.out.println("Suma, " +suma);
		
		suma = enteros.stream()
			.filter(valor -> valor > 0)
			.reduce(0, (x, y) -> x + y); //operacion terminal
		
		System.out.println("Suma con reduce, " +suma);
	}

}
