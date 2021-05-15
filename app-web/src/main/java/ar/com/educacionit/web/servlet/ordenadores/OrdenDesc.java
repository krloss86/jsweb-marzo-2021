package ar.com.educacionit.web.servlet.ordenadores;

import java.util.Comparator;

import ar.com.educacionit.domain.Producto;

public class OrdenDesc implements Comparator<Producto>{
	@Override
	public int compare(Producto o1, Producto o2) {
		return o2.getPrecio().compareTo(o1.getPrecio());
	}
}
