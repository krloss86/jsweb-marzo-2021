package ar.com.educacionit.clase3;

public class AtributoClaseMain {

	public static void main(String[] args) {
		//Clase.atributo|metodo ->accede a un atributo de Clase
		String tipoA = Articulo.tipo;
		System.out.println(tipoA);
		
		Libro l = new Libro("TONY STAR IRON MAN 01: UN...","SCOTT DAN", 830f, "9786076343043", "PANINI");
		//atributo de instancia
		//Objeto.metodo|atributo
		String tipoL = l.tipo;
		System.out.println(tipoL);

		//cambia el valor de la clase
		Articulo.tipo = "RESULTADO";
		
		Pasatiempo p = new Pasatiempo("IRON MAN 15 CENTIMETROS -",117.99f, "HASBRO","630509294756");
		
		String tipoP = p.tipo;
		System.out.println(tipoP);
		
		tipoL = l.tipo;
		System.out.println(tipoL);
	}

}
