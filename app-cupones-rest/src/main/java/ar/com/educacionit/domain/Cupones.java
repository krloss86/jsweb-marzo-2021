package ar.com.educacionit.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cupones")
public class Cupones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "nombre")
	private String nombre;
	
	@NotEmpty
	@Column(name = "codigo", unique = true)
	private String codigo;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_vigencia_desde")	
	private Date fechaVigenciaDesde;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_vigencia_hasta")	
	private Date fechaVigenciaHasta;
	
	@NotNull(message = "Complete el descuento")
	@Min(message = "Debe ser >= 0", value = 0)
	@Max(message = "Debe ser <= 0", value = 100)
	@Column(name = "descuento")
	private Double descuento;
	
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
	
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
