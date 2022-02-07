package es.jcf.core.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseAuditSO extends BaseSO{

	@Column(name = "FECHAMOD")
	private Date fechamod;
	

	@Column(name = "FECHAALTA", nullable = false)
	private Date fechaalta;
	
	
	public BaseAuditSO(Date fechaalta, Date fechamod) {
		super();
		this.fechaalta = fechaalta;
		this.fechamod = fechamod;
	}
	
}