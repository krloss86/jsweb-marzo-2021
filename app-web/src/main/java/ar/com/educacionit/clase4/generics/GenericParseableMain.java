package ar.com.educacionit.clase4.generics;

public class GenericParseableMain {

	public static void main(String[] args) {
		
		ClaseHija claseHija = new  ClaseHija("hola"); 
		IParseable<Long> parseableLong = claseHija.crearAlgo();
		
		claseHija.saludar();
		
		Long longV = parseableLong.parse();
	}

}
