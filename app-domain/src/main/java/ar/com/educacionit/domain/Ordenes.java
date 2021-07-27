package ar.com.educacionit.domain;

import java.io.Serializable;
import java.util.Date;

public class Ordenes extends Entity {

	private Long id;
	private Date fechaCreacion;
	private Long sociosId;
	private Long estadosOrdenesId;
	private Float montoTotal;
	private Long cuponesId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	public Long getSociosId() {
		return sociosId;
	}
	public void setSociosId(Long sociosId) {
		this.sociosId = sociosId;
	}
	public Long getEstadosOrdenesId() {
		return estadosOrdenesId;
	}
	public void setEstadosOrdenesId(Long estadosOrdenesId) {
		this.estadosOrdenesId = estadosOrdenesId;
	}
	public Float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Long getCuponesId() {
		return cuponesId;
	}
	public void setCuponesId(Long cuponesId) {
		this.cuponesId = cuponesId;
	}
	
	@Override
	public void setId(Serializable id) {
		this.setId((Long)id);
	}
	
	@Override
	public String toString() {
		return "Ordenes [id=" + id + ", fechaCreacion=" + fechaCreacion + ", socioId=" + sociosId + ", estadosOdenesId="
				+ estadosOrdenesId + ", montoTotal=" + montoTotal + ", cuponesId=" + cuponesId + "]";

	}
}
