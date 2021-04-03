package ar.com.educacionit.clase5;

public class Cliente implements Comparable<Cliente>{

	private Long id;
	
	private String nombre;
	
	private Integer edad;
	
	private boolean embarazada;

	public Cliente(Long id, String nombre, Integer edad) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Cliente(Long id, String nombre, Integer edad, boolean embarazada) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.embarazada = embarazada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public boolean isEmbarazada() {
		return embarazada;
	}

	public void setEmbarazada(boolean embarazada) {
		this.embarazada = embarazada;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int compareTo(Cliente otroCliente) {
		//orden asc por edad
		// return this.getEdad().compareTo(otroCliente.getEdad());
		
		if(!isEmbarazada())
			return otroCliente.getEdad().compareTo(this.getEdad());
		else
			return -1;//tiene la prioriad this
	}
	
}
