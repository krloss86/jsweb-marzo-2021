package ar.com.educacionit.clase3;

//herencia
public class Libro extends Articulo {
	
	public final String nombre ="ARTICULO";
	
	//atributos propios
	private String isbn;
	private String editorial;
	
	public Libro(String titulo, Float precio, String isbn,String editorial) {
		//tiene que nacer el padre
		super(titulo, precio);//LLAMAR AL CONSTRUCTOR DEL PADRE
		
		//seteo los atributos del hijo
		inicializar(isbn, editorial);	
		
		//super.nombre = "JOSE";
	}

	private void inicializar(String isbn, String editorial) {
		this.editorial = editorial;
		this.isbn = isbn;
	}
	
	public Libro(String titulo, String autor, Float precio, String isbn,String editorial) {
		super(titulo, autor, precio);
		inicializar(isbn, editorial);
	}
	

	// GET/SET
	//ALT+SHIT+S
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	//Sobreescritura = polimorfismo con redefinición
	public void displayHijo() {
		System.out.println("LIBRO");		
		System.err.println("ISBN: "+ this.isbn);
		System.err.println("Editorial: "+ this.editorial);		
	}
	
}
