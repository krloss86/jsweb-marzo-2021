package ar.com.educacionit.web.servlet.ordenadores;

import java.util.Comparator;

import ar.com.educacionit.domain.Articulos;

public class OrdenAsc implements Comparator<Articulos>{
	@Override
	public int compare(Articulos o1, Articulos o2) {
		return o1.getPrecio().compareTo(o2.getPrecio());
	}
}
