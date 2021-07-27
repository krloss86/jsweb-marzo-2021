package ar.com.educacionit.domain;

import java.util.Date;

public class PagosOrdenes {

	private Long ordenesId;
	private Long mediosPagosId; 
	private Date fechaPago;
	private Float montoPagado;
	
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
	public Float getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(Float montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	@Override
	public String toString() {
		return "PagosOrdenes [ordenesId=" + ordenesId + ", mediosPagosId=" + mediosPagosId + ", fechaPago=" + fechaPago
				+ ", montoPagado=" + montoPagado + "]";
	}
	
	
}
