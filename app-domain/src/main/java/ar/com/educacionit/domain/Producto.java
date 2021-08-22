package ar.com.educacionit.domain;

public class Producto extends Entity{

	private Long id;
	private String titulo;
	private Double precio;
	private String codigo;
	private Long tipoProducto;

	//agrego contructor: db ->java 
	public Producto(Long id, String titulo, Double precio, String codigo, Long tipoProducto) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}
	
	//otro sin id: java -> db
	public Producto(String titulo, Double precio, String codigo, Long tipoProducto) {
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}

	public Producto() {
		
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	//alt+shift+s
	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", codigo=" + codigo
				+ ", tipoProducto=" + tipoProducto + "]";
	}

	public String toCSV() {
		return titulo + ";" + precio + ";" + codigo + ";" + tipoProducto;
	}
	
}
