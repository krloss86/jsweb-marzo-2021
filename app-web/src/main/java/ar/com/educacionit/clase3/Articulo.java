package ar.com.educacionit.clase3;

import java.util.Arrays;

public class Articulo implements Comparable<Articulo> {

	public final String nombre = "ARTICULO";
	
	//SON ATRIBUTOS DE INSTANCIA
	private String titulo;
	private String autor;
	private Float precio;
	private String imagenPpal;
	private String[] imagenesExtras;
	
	//ATRIBUTO DE CLASE
	static String tipo = "ARTICULO";
	public static Integer cantidadInstancias = 0;//inicia en cero
	
	//alt+shift+s
	public Articulo(String titulo, String autor, Float precio) {
		inicializar(titulo, precio);
		this.autor = autor;
	}

	public Articulo(String titulo, Float precio) {
		inicializar(titulo, precio);
	}
	
	private void inicializar(String titulo, Float precio) {
		this.titulo = titulo;
		this.precio = precio;
		
		this.imagenPpal = "";
		this.imagenesExtras = new String[] {};
		//aumento en 1 la cantidad de instancias
		Articulo.cantidadInstancias++;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}	
	
	/**
	 * A nivel de mÉtodo final evita que pueda ser sobreescrito
	 * @return
	 */
	public final boolean tieneAutor() {
		return this.autor != null;
	}
	
	/**
	 * nadie puede sobreescribir este metodo
	 */
	public final void display() {
		
		System.out.println("Titulo: "+ this.getTitulo());
		System.out.println("Autor: ");
		if(this.tieneAutor()) {
			System.out.println(this.getAutor());
		}
			
		System.out.println("Precio: " +this.getPrecio());
	
		System.out.println("Imagen Ppal:");
		//agregamos los dos atributos:imagenPpal e imagenesExtras
		if(this.tieneImagen()) {
			System.out.println(this.imagenPpal);
		}
		
		System.out.println("Imagenes Extras:");
		if(this.tieneImagenesExtras()) {
			System.out.println(Arrays.toString(this.imagenesExtras));
		}
		
		//desde el padre llamo un metodo del hijo!!!
		this.displayHijo();
	}

	//por defecto este metodo no tiene logica!
	public void displayHijo() {
	}

	public String getImagenPpal() {
		return imagenPpal;
	}

	public void setImagenPpal(String imagenPpal) {
		this.imagenPpal = imagenPpal;
	}

	public String[] getImagenesExtras() {
		return imagenesExtras;
	}

	public void setImagenesExtras(String[] imagenesExtras) {
		this.imagenesExtras = imagenesExtras;
	}
	
	public boolean tieneImagen() {
		return !this.imagenPpal.equals("");
	}
	public boolean tieneImagenesExtras() {
		return this.imagenesExtras.length > 0; 
	}

	@Override
	//>  0
	//<  0
	// == 0
	public int compareTo(Articulo otroArticulo) {
		
		Articulo esteArticulo = this;
		
		return otroArticulo.getPrecio().compareTo(esteArticulo.getPrecio());
	}

	@Override
	public String toString() {
		return "Articulo [titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}
	
	//alt+shit+s
	
}

