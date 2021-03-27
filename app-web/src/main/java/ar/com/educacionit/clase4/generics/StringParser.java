package ar.com.educacionit.clase4.generics;

public class StringParser implements IParseable<String> {

	@Override
	public String parse() {
		return new String(" Segundos: " + System.currentTimeMillis());
	}
}
