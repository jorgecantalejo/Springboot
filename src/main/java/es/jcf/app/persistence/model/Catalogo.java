package es.jcf.app.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CATALOGO")
public class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCATALOGO", updatable = false, nullable = false)
	private Long idCatalogo;

	@Column(name = "CODIGO", nullable = false)
	private String codigo;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Builder.Default
	@Column(name = "ACTIVO", nullable = false)
	private Boolean activo = true;

	@Column(name = "FECHAALTA", nullable = false)
	private Date fechaalta;

	@Column(name = "FECHABAJA")
	private Date fechabaja;

	@Column(name = "FECHAMOD")
	private Date fechamod;

	public Catalogo(Long idCatalogo, String codigo, String nombre, Boolean activo, Date fechaalta, Date fechabaja,
			Date fechamod) {
		super();
		this.idCatalogo = idCatalogo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.activo = activo;
		this.fechaalta = fechaalta;
		this.fechabaja = fechabaja;
		this.fechamod = fechamod;
	}

}