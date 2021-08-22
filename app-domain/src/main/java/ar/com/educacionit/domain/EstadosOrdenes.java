package ar.com.educacionit.domain;

public class EstadosOrdenes extends Entity{

	private Long id;
	private String descripcion;
	private String descripcionCorta;
	private Long estadoFinal;
	
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

	public Long getEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(Long estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	
	@Override
	public String toString() {
		return "EstadosOrdenes [id=" + id + ", descripcion=" + descripcion + ", estadoFinal=" + estadoFinal + "]";
	}
	
}
