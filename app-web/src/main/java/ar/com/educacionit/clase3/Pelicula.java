package ar.com.educacionit.clase3;

/**
 * Con final a nivel de clase cortamos linea de herencia
 * @author CHLopez
 *
 */
public final class Pelicula extends Articulo {

	private String productora;
	private String clasificacion;
	
	public Pelicula(String titulo, String autor, Float precio, String productora, String clasificacion) {
		super(titulo, autor, precio);
		inicializar(productora, clasificacion);
	}
	public Pelicula(String titulo, Float precio, String productora, String clasificacion) {
		super(titulo, precio);
		inicializar(productora, clasificacion);
	}
	private void inicializar(String productora, String clasificacion) {
		this.productora = productora;
		this.clasificacion = clasificacion;
	}
	public String getProductora() {
		return productora;
	}
	public void setProductora(String productora) {
		this.productora = productora;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	//ctrl+space
	@Override
	public void displayHijo() {
		System.out.println("PELICULA");
		System.err.println("Productora: " + this.productora);
		System.err.println("Clasificación: " + this.clasificacion);
	}
}

