package ar.com.educacionit.domain;

public class OrdenesItems {

	private Long ordenesId;
	private Integer numeroItem;
	private Integer cantidad;
	private Long articulosId;

	public Long getOrdenesId() {
		return ordenesId;
	}
	public void setOrdenesId(Long ordenesId) {
		this.ordenesId = ordenesId;
	}
	public Integer getNumeroItem() {
		return numeroItem;
	}
	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
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
	
}
