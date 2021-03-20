package ar.com.educacionit.clase3;

public class CasteoObjetosMain {

	public static void main(String[] args) {

		Articulo articulo = new Libro("TONY STAR IRON MAN 01: UN...","SCOTT DAN", 830f, "9786076343043", "PANINI");
		//down casting -> hijos
		articulo.getAutor();
		articulo.getPrecio();
		articulo.getTitulo();
		
		Libro libro = (Libro)articulo;
		libro.getIsbn();
		libro.getEditorial();
		
		articulo = (Articulo)libro;
		
		//-------------------------
		
		// Musica musica = (Musica)articulo;//NO SE PUEDE
		
		System.out.println("fin");
	}

}
