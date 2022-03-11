package es.jcf.app.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import es.jcf.core.persistence.model.BaseAuditSO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class Usuario extends BaseAuditSO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIO", updatable = false, nullable = false)
	private Long idUsuario;

	@NotBlank(message = "Login no puede estar vacio")
	@Column(name = "LOGIN", nullable = false)
	private String login;

	@NotBlank(message = "Contrasenia no puede estar vacio")
	@Column(name = "CONTRASENIA", nullable = false)
	private String contrasenia;
	
	@NotBlank(message = "Hash no puede estar vacio")
	@Column(name = "HASH", nullable = false)
	private String hash;
	

	@NotBlank(message = "Nombre no puede estar vacio")
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@NotBlank(message = "Apellido no puede estar vacio")
	@Column(name = "APELLIDO", nullable = false)
	private String apellido;
	
	@Column(name = "EMAIL", nullable = true)
	private String email;

	@Builder.Default
	@Column(name = "ACTIVO", nullable = false)
	private Boolean activo = true;


	@Column(name = "FECHABAJA")
	private Date fechabaja;
	
	Usuario(){
		
	}

	public Usuario(Long idUsuario,String login,String contrasenia,String hash,String nombre,String apellido, 
			String email, 
			Boolean activo,
			Date fechabaja) {
		super(new Date(), null);
		this.idUsuario = idUsuario;
		this.login = login;
		this.contrasenia = contrasenia;
		this.hash = hash;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.activo = activo;
		this.fechabaja = fechabaja;
	}
	

}