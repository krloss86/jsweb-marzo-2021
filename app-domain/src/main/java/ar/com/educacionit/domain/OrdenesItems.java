package ar.com.educacionit.domain;

import java.io.Serializable;

public class OrdenesItems extends Entity{

	private Long id;
	private Long ordenesId;
	private Long numeroItem;
	private Long cantidad;
	private Long articulosId;
	private Double precioUnitario;

	public Long getOrdenesId() {
		return ordenesId;
	}
	public void setOrdenesId(Long ordenesId) {
		this.ordenesId = ordenesId;
	}
	public Long getNumeroItem() {
		return numeroItem;
	}
	public void setNumeroItem(Long numeroItem) {
		this.numeroItem = numeroItem;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Long getArticulosId() {
		return articulosId;
	}
	public void setArticulosId(Long articulosId) {
		this.articulosId = articulosId;
	}
	
	@Override
	public String toString() {
		return "OrdenesItems [ordenesId=" + ordenesId + ", numeroItem=" + numeroItem + ", cantidad=" + cantidad
				+ ", articulosId=" + articulosId + "]";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
