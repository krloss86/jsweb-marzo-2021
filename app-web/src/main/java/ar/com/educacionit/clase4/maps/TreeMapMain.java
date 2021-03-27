package ar.com.educacionit.clase4.maps;

import java.util.TreeMap;

import ar.com.educacionit.clase2.Auto;

public class TreeMapMain {

	public static void main(String[] args) {

		// ojo que debe implementar Comparable la clave del mapa
		//crear 
		TreeMap<Auto, Integer> autosMap = new TreeMap<>();
		
		Auto auto = new Auto("renaul","clio","azul",220);
		
		autosMap.put(auto,1);
		
		auto = new Auto("ford","astra","azul",220);
		autosMap.put(auto,0);
		
		auto = new Auto("chery","tigo","azul",220);
		autosMap.put(auto,-5);
		
		System.out.println(autosMap);

	}

}
