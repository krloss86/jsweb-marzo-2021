package ar.com.educacionit.web.servlet.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFilter {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(-1);
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);
		
		Integer valor = 15;
		
		List<Integer> enterosMayoresA15 = new ArrayList<>();
		
		for(Integer aux : enteros) {
			if(aux > valor) {
				enterosMayoresA15.add(aux);
			}
		}
				
		System.out.println(enterosMayoresA15);
		
		
		Stream<Integer> str = enteros.stream();
		
		str = str.filter(x -> x > 0 && x < 20 ); //funcion intermedia
		
		str = str.filter(x -> x > valor);//funcion intermedia
		
		//function terminal
		List<Integer> filtrados = str.collect(Collectors.toList());
				
		System.err.println(filtrados);
		
		filtrados =	enteros.stream()
					.filter(x -> x >0 && x < 20)
					.filter(x -> x > valor)
					.collect(Collectors.toList());
		
		System.err.println(filtrados);
	}

}
