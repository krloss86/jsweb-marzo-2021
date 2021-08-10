package ar.com.educacionit.web.dto;

public class Checkout {

	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private Long paisesId;
	
	public Checkout() {
		this.nombre = "";
		this.apellido = "";
		this.email = "";
		this.direccion = "";
		this.paisesId = -1L;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getPaisesId() {
		return paisesId;
	}

	public void setPaisesId(Long paisesId) {
		this.paisesId = paisesId;
	}
	
	

}
