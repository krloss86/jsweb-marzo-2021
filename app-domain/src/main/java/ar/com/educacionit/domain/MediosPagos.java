package ar.com.educacionit.domain;

public class MediosPagos extends Entity {

	private Long id;
	private String codigo;
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
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return "MediosPagos [id=" + id + ", descripcion=" + descripcion + ", habilitada=" + habilitada + "]";
	}
	
}
