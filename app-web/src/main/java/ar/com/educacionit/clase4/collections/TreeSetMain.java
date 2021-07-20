package ar.com.educacionit.clase4.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		
		TreeSet<Integer> alturas = new TreeSet<>();

		alturas.add(172);
		alturas.add(173);
		alturas.add(170);
		alturas.add(169);
		alturas.add(171);
		
		//169 170 173 172 173
		
		System.out.println(alturas);
	}

}
