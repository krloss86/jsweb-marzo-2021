package ar.com.educacionit.clase6.jdbc.menu;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDao;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;

public abstract class AccionBase {

	protected Scanner teclado;
	protected ProductoDao pdao;
	
	public AccionBase() {
		pdao = new ProductoDAOJdbcImpl();
	}
	
	public void setTeclado(Scanner teclado) {
		this.teclado = teclado;
	}
}
