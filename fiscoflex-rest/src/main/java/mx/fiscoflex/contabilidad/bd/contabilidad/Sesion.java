package mx.fiscoflex.contabilidad.bd.contabilidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sesion")
public class Sesion {
	
	@Id
	@Column(name = "IdSesion")
	private String idSesion;	

	@Column(name = "FechaCreacion")
	private Date fechaCreacion;

	@Column(name = "FechaExpiracion")
	private Date fechaExpiracion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdUsuario")
	private Usuario usuario;

	@Column(name = "Activo")
	private Boolean activo;

	
}