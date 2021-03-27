package ar.com.educacionit.clase4.generics;

public class NumeroParser implements IParseable<Long> {

	@Override
	public Long parse() {
		return System.currentTimeMillis();
	}
}
