package ar.com.educacionit.clase3;

import java.util.Arrays;

public class Musica extends Articulo {

	private String sello;
	private String[] temas;
	
	public Musica(String titulo, String autor, Float precio, String sello, String[] temas) {
		super(titulo, autor, precio);
		inicializar(sello, temas);
	}

	private void inicializar(String sello, String[] temas) {
		this.sello = sello;
		this.temas = temas;
	}
	
	public Musica(String titulo, Float precio, String sello, String[] temas) {
		super(titulo, precio);
		inicializar(sello, temas);
	}

	public String getSello() {
		return sello;
	}

	public void setSello(String sello) {
		this.sello = sello;
	}

	public String[] getTemas() {
		return temas;
	}

	public void setTemas(String[] temas) {
		this.temas = temas;
	}
	
	@Override
	public void displayHijo() {
		System.out.println("MUSICA");
		System.err.println("Sello: " + this.sello);
		System.err.println("Temas: " + Arrays.toString(this.temas)); 
	}
	
	/*public boolean tieneAutor() {
		return true;
	}*/
}
