package es.jcf.app.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import es.jcf.core.persistence.model.BaseAuditSO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@Entity
@Table(name = "CATALOGO")
public class Catalogo extends BaseAuditSO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCATALOGO", updatable = false, nullable = false)
	private Long idCatalogo;

	@NotBlank(message = "Codigo no puede estar vacio")
	@Column(name = "CODIGO", nullable = false)
	private String codigo;

	@NotBlank(message = "Codigo no puede estar vacio")
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Builder.Default
	@Column(name = "ACTIVO", nullable = false)
	private Boolean activo = true;


	@Column(name = "FECHABAJA")
	private Date fechabaja;
	
	Catalogo(){
		
	}

	public Catalogo(Long idCatalogo, String codigo, String nombre, Boolean activo, Date fechabaja) {
		super(new Date(), null);
		this.idCatalogo = idCatalogo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.activo = activo;
		this.fechabaja = fechabaja;
	}

	public Catalogo(Long idCatalogo, String codigo, String nombre, Boolean activo, Date fechaalta, Date fechabaja,
			Date fechamod) {
		super(fechaalta,fechamod);
		this.idCatalogo = idCatalogo;
		this.codigo = codigo;
		this.nombre = nombre;
		this.activo = activo;
		this.fechabaja = fechabaja;
	}

}