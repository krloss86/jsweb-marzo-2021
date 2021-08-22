package ar.com.educacionit.domain;

import java.util.Date;
import java.util.List;

public class Ordenes extends Entity {

	private Long id;
	private Date fechaCreacion;
	private Long sociosId;
	private Long estadosOrdenesId;
	private Double montoTotal;
	private Long cuponesId;
	
	private List<OrdenesItems> items;
	private DireccionesOrdenes direccionOrden;
	private PagosOrdenes pagoOrden;
	
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
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Long getCuponesId() {
		return cuponesId;
	}
	public void setCuponesId(Long cuponesId) {
		this.cuponesId = cuponesId;
	}
		
	@Override
	public String toString() {
		return "Ordenes [id=" + id + ", fechaCreacion=" + fechaCreacion + ", socioId=" + sociosId + ", estadosOdenesId="
				+ estadosOrdenesId + ", montoTotal=" + montoTotal + ", cuponesId=" + cuponesId + "]";

	}
	public List<OrdenesItems> getItems() {
		return items;
	}
	public void setItems(List<OrdenesItems> items) {
		this.items = items;
	}
	public DireccionesOrdenes getDireccionOrden() {
		return direccionOrden;
	}
	public void setDireccionOrden(DireccionesOrdenes direccionOrden) {
		this.direccionOrden = direccionOrden;
	}
	public PagosOrdenes getPagoOrden() {
		return pagoOrden;
	}
	public void setPagoOrden(PagosOrdenes pagoOrden) {
		this.pagoOrden = pagoOrden;
	}
		
}
