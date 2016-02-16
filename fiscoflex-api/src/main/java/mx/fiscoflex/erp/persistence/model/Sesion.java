package mx.fiscoflex.erp.persistence.model;

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
	
	@Column(name = "IP")
	private String ip;
	
	@Column(name = "Token")
	private String token;

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

	
}