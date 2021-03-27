package ar.com.educacionit.clase4.generics;

public class GenericMain {

	public static void main(String[] args) {
		
		IParseable<Long> numeroParseable = new NumeroParser();

		Long valorParseado = numeroParseable.parse();
		
		IParseable<String> stringParseable = new StringParser();
		
		String valorParseado2 = stringParseable.parse(); 
	}

}
