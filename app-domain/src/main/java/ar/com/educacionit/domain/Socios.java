package ar.com.educacionit.domain;

import java.io.Serializable;
import java.util.Date;

public class Socios extends Entity {

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaAlta;
	private String direccion;
	private Long paisesId;
	
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
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	@Override
	public void setId(Serializable id) {
		setId((Long)id);
	}
	
	@Override
	public String toString() {
		return "Socioas [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fechaAlta=" + fechaAlta + "]";
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
