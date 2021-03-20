package ar.com.educacionit.interfaces.entidades;

import ar.com.educacionit.interfaces.IIDioma;

public class Persona {

	private String nombre;
	private String apellido;
	
	private IIDioma idiomaNativo;
	private IIDioma[] idiomas;
	
	public Persona(String nombre, String apellido, IIDioma idiomaNativo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idiomaNativo = idiomaNativo;
		this.idiomas = new IIDioma[0];
	}
	
	public void aprender(IIDioma nuevoIdioma) {
		//hay que controlar que el nuevoIdioma no este en la lista!
		//home work
		IIDioma[] actuales = new IIDioma[this.idiomas.length + 1];
		int i=0;
		for(IIDioma idiomaQueSabe : this.idiomas) {
			actuales[i++]=idiomaQueSabe;
		}
		actuales[i]=nuevoIdioma;
		this.idiomas = actuales;
	}
	
	public void decir(String palabra) {
		this.idiomaNativo.decir(palabra);
	}
	
	public void decir(String palabra, IIDioma unIdioma) {
		boolean sabeEseIdioma = false;
		for(IIDioma idiomaQueSabe : this.idiomas) {
			if(idiomaQueSabe.equals(unIdioma)) {
				sabeEseIdioma = true;
				break;
			}
		}
		if(sabeEseIdioma) {
			unIdioma.decir(palabra);
		}else {
			unIdioma.noseDecir(palabra);
		}
	}
}
