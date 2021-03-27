package ar.com.educacionit.clase4.generics;

public class ClaseHija extends ClaseBase<IParseable<Long>> {

	public ClaseHija(String saludo) {
		super(saludo);
	}

	@Override
	public IParseable<Long> crearAlgo() {		
		return new NumeroParser();
	}

}
