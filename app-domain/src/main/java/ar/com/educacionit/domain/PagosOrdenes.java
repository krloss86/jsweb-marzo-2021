package ar.com.educacionit.domain;

import java.util.Date;

public class PagosOrdenes extends Entity {

	private Long id;
	private Long ordenesId;
	private Long mediosPagosId; 
	private Date fechaPago;
	private Double monto;
	
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
	
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	@Override
	public String toString() {
		return "PagosOrdenes [ordenesId=" + ordenesId + ", mediosPagosId=" + mediosPagosId + ", fechaPago=" + fechaPago
				+ ", monto=" + monto + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
