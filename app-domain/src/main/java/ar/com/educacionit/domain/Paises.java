package ar.com.educacionit.domain;

public class Paises extends Entity{

	private Long id;
	private String descripcion;
	private String descripcionCorta;
	private Long habilitada;
	
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
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	
	public Long getHabilitada() {
		return habilitada;
	}
	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}
	
	@Override
	public String toString() {
		return "Paises [id=" + id + ", descripcion=" + descripcion + ", descripcionCorta=" + descripcionCorta + "]";
	}
	
}
