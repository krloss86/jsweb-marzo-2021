package ar.com.educacionit.web.servlet.ordenadores;

import java.util.Comparator;

import ar.com.educacionit.domain.Articulos;

public class OrdenDesc implements Comparator<Articulos>{
	@Override
	public int compare(Articulos o1, Articulos o2) {
		return o2.getPrecio().compareTo(o1.getPrecio());
	}
}
