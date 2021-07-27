package ar.com.educacionit.domain;

public class MediosPagos {

	private Long id;
	private String descripcion;
	private Boolean habilitado;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	@Override
	public String toString() {
		return "MediosPagos [id=" + id + ", descripcion=" + descripcion + ", habilitado=" + habilitado + "]";
	}
	
}
