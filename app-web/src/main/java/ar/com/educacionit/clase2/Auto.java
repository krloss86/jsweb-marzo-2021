package ar.com.educacionit.clase2;

//nombre de la clase
public class Auto implements Comparable<Auto>{

	//atributos
	private String marca;
	private String modelo;
	private int anio;
	private String color;
	private float velocidad;
	private float velocidadMaxima;
	private float combustible;
	private boolean encendido;	
	
	//constructor: defecto, porque no tiene parametros
	public Auto(){
		//inicializar ciertos atributos de un objeto
		encendido = false;
		combustible = 0;
		anio = 2021;
		velocidad = 0;
		velocidadMaxima = 250;
	}
	
	//contructor: parametrizado
	public Auto(String marca, String modelo, String color, float velocidadMaxima) {
		encendido = false;
		combustible = 0;
		anio = 2021;
		velocidad = 0;
		this.modelo = modelo;
		this.marca = marca;
		this.velocidadMaxima = velocidadMaxima;
		this.color = color;
	}
	
	//metodos
	public void encender() {
		if(!encendido) {
			encendido = true;
			System.out.println("Se ha encenido el auto");
		}else {
			System.out.println("Auto ya está encendido");
		}		
	}
	
	public void apagar() {
		if(encendido) {
			encendido = false;
			System.out.println("Se ha apagado el auto");
		}else {
			System.out.println("Auto ya está apagado");
		}
	}
	
	public void acelerar() {		
		if(encendido) {
			if(velocidad < velocidadMaxima) {
				if(combustible > 0) {
					velocidad++;
					combustible--;
				}else {
					System.out.println("No hay mas combustible");
				}
			}else {
				System.out.println("Ha llegado a la velocidad máxima");
			}
		}
	}
	
	public float obtenerVelocidad() {
		return velocidad;
	}
	
	public void informarEstado() {
		System.out.println("Marca: "+ this.marca);
		System.out.println("Modelo: "+ this.modelo);
		System.out.println("Año: "+ this.anio);
		System.out.println("Color: "+ this.color);
		System.err.println("Encendido: "+ this.encendido);
		System.out.println("Velocidad: "+ this.velocidad);
		System.out.println("Velocidad Máxima: "+ this.velocidadMaxima);
		System.out.println("Combustible: "+ this.combustible);
	}
	
	//getters/setters @~|
	public void setMarca(String marca) {
		if(marca != null) {
			//ejercicio
			this.marca = marca.toUpperCase();
		}else {
			System.out.println("Marca no puede ser null");
		}
	}
	
	public String getMarca() {		
		return this.marca;
	}
	
	@Override
 	public int compareTo(Auto o) {
 		//return this.marca.compareTo(o.getMarca());
		return o.getMarca().compareTo(this.marca);
 	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + "]";
	}	
		
}
