package ar.com.educacionit.domain;

import java.io.Serializable;
import java.util.Date;

public class Cupones extends Entity {

	private Long id;
	private String nombre;
	private String codigo;
	private Date fechaVigenciaDesde;
	private Date fechaVigenciaHasta;
	private Float descuento;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}
	public void setFechaVigenciaDesde(Date fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}
	public Date getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}
	public void setFechaVigenciaHasta(Date fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
	}
	
	public Float getDescuento() {
		return descuento;
	}
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public void setId(Serializable id) {
		setId((Long)id);
	}
	
	@Override
	public String toString() {
		return "Cupones [id=" + id + ", nombre=" + nombre + ", fechaVigenciaDesde=" + fechaVigenciaDesde
				+ ", fechaVigenciaHasta=" + fechaVigenciaHasta + ", descuento=" + descuento+ "]";
	}
	
}
