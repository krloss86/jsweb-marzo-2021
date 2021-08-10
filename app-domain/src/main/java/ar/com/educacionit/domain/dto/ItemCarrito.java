package ar.com.educacionit.domain.dto;

public class ItemCarrito {

	private Long id;
	private String titulo;
	private Double precio;
	private Integer cantidad;

	public ItemCarrito(Long id, String titulo, Double precio, Integer cantidad) {
		this.id = id;
		this.precio = precio;
		this.titulo = titulo;
		this.cantidad = cantidad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public void actualizarCantidad(Integer cantidad) {
		this.cantidad += cantidad;				
	}
}
