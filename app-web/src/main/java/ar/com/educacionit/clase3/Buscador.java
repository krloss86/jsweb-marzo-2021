package ar.com.educacionit.clase3;

public class Buscador {

	//atributos
	private String claveBusqueda;
	private Integer cantidadResultados;
	private Articulo[] resultados;
	
	//contructor
	public Buscador() {
		this.resultados = new Articulo[0];
		this.cantidadResultados = 0;
		this.claveBusqueda = "";
	}
	
	public void buscar() {
		//select * from articulos where titulo like '%this.claveBusqueda%'
		//Padre[] res = new  Padre[];
		
		Libro libro = new Libro("TONY STAR IRON MAN 01: UN...","SCOTT DAN", 830f, "9786076343043", "PANINI");
		libro.setImagenPpal("https://www.tematika.com/media/catalog/Ilhsa/Imagenes/679608.jpg");
		
		Libro libro2 = new Libro("INVENCIBLE IRON MAN, EL.", "BENDIS, BRIAN MICHAEL", 1525f, "9789877244489", "OVNI PRESS");
		libro2.setImagenPpal("https://www.tematika.com/media/catalog/Ilhsa/Imagenes/667993.jpg");
		
		Pasatiempo pasatiempo = new Pasatiempo("IRON MAN 15 CENTIMETROS -",117.99f, "HASBRO","630509294756");
		pasatiempo.setImagenPpal("https://www.tematika.com/media/catalog/Ilhsa/Imagenes/657214.jpg");
		String[] imagenesExtrasPasatiempo = new String[] {
				"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/657215.jpg",
				"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/657216.jpg"
		};
		pasatiempo.setImagenesExtras(imagenesExtrasPasatiempo);
		
		Articulo[] resultados = new Articulo[] {				
				libro,
				libro2,
				pasatiempo,
				new Musica("INVENCIBLE IRON MAN 2 MA...","BENDIS, BRIAN MICHAEL / DEODATO, MICHAE",1125f, "SONY MUSIC", 
						new String[] {
								"1-SHOOT OT THRILL",
								"2-ROCK N ROLL DAMNATION",
								"3-GUNS FOR HIRE",
								"4-COLD HEARTED MAN"
						}),
				new Pelicula("IRON MAN 3", 850F, "THE WALT DISNEY COMPANY", "Apta para todo público")
		};
		
		this.resultados = resultados;
		
		this.cantidadResultados = resultados.length;
	}
	
	public String getClaveBusqueda() {
		return this.claveBusqueda;
	}
	
	public void setClaveBusqueda(String claveBuscada) {
		this.claveBusqueda = claveBuscada.toUpperCase();
	}
	
	public Integer getCantidadResultados() {
		return this.resultados.length;//tamaño del vector
	}
	
	// getter que retorna los String[]
	public Articulo[] getResultados() {
		return this.resultados;
	}
	
	public boolean hayResultados() {
		return this.cantidadResultados > 0;
	}
}
