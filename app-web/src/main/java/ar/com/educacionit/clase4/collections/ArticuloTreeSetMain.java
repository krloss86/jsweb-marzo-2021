package ar.com.educacionit.clase4.collections;

import java.util.Set;
import java.util.TreeSet;

import ar.com.educacionit.clase3.Articulo;

public class ArticuloTreeSetMain {

	public static void main(String[] args) {
		//Interfaces i = new Clase()
		Set<Articulo> articulos = new TreeSet<Articulo>();
		
		Articulo articulo = new Articulo("mate listo", 100f);
		articulos.add(articulo);
		
		articulo = new Articulo("mate listo", 500f);
		articulos.add(articulo);
		
		articulo = new Articulo("mate listo", 50f);
		articulos.add(articulo);

		System.out.println(articulos);
	}

}
