package ar.com.educacionit.domain;

import java.util.Date;

public class DireccionesOrdenes {

	private Long ordenesId;
	private Long mediosPagosId;
	private Date fechaPago;
	
	public Long getOrdenesId() {
		return ordenesId;
	}
	public void setOrdenesId(Long ordenesId) {
		this.ordenesId = ordenesId;
	}
	public Long getMediosPagosId() {
		return mediosPagosId;
	}
	public void setMediosPagosId(Long mediosPagosId) {
		this.mediosPagosId = mediosPagosId;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	@Override
	public String toString() {
		return "DireccionesOrdenes [ordenesId=" + ordenesId + ", mediosPagosId=" + mediosPagosId + ", fechaPago="
				+ fechaPago + "]";
	}
	
}
