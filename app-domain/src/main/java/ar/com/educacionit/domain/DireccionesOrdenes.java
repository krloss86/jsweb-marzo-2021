package ar.com.educacionit.domain;

public class DireccionesOrdenes extends Entity {

	private Long id;	
	private Long ordenesId;
	private Long paisesId;
	private String direccionEnvio;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrdenesId() {
		return ordenesId;
	}

	public void setOrdenesId(Long ordenesId) {
		this.ordenesId = ordenesId;
	}

	public Long getPaisesId() {
		return paisesId;
	}

	public void setPaisesId(Long paisesId) {
		this.paisesId = paisesId;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}
	
}
