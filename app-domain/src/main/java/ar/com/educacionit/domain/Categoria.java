package ar.com.educacionit.domain;

import java.io.Serializable;

/**
 * Tabla categorias
 * @author CHLopez
 *
 */
public class Categoria extends Entity{

	private Long id;
	private String descripcion;
	private String codigo;
	private Long habilitada;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getHabilitada() {
		return habilitada != null ? habilitada : 0;
	}

	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public void setId(Serializable id) {
		this.id = (Long)id;
	}
	
}
