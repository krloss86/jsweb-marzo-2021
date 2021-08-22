package ar.com.educacionit.domain;

import java.util.Date;

public class Articulos extends Entity {

	private Long id;
	private String titulo;
	private String codigo;
	private Date fechaCreacion;
	private Double precio;
	private Long stock;
	private Long marcasId;
	private Long categoriasId;

	public Articulos() {
	
	}

	public Articulos(Long id, String titulo, String codigo, Double precio, Long stock, Long marcasId,
			Long categoriasId) {
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcasId;
		this.categoriasId = categoriasId;
	}

	public Articulos(String titulo, String codigo, Double precio, Long stock, Long marcasId, Long categoriasId) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcasId;
		this.categoriasId = categoriasId;
		this.fechaCreacion = new Date();
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
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public Long getMarcasId() {
		return marcasId;
	}
	public void setMarcasId(Long marcasId) {
		this.marcasId = marcasId;
	}
	public Long getCategoriasId() {
		return categoriasId;
	}
	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + ", precio=" + precio
				+ ", stock=" + stock + ", marcasId=" + marcasId + ", categoriasId=" + categoriasId + "]";
	}
	
}
