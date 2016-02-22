package mx.fiscoflex.contabilidad.persistencia;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bitacora")
public class BitacoraEntity {

	@Id
	@Column(name="IdBitacora")
	private String idBitacora;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdAccion")
	private AccionEntity accion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdUsuario")
	private UsuarioEntity usuario;
	
	@Column(name="Fecha")
	private Date fecha;
	
	@Column(name="MarcaTemporal")
	private Date marcaTemporal;
	
	@Column(name="Entrada")
	private String entrada;
	
	@Column(name="Salida")
	private String salida;
	
	@Column(name="IP")
	private String ip;
	
	@Column(name="Actividad")
	private String actividad;

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public AccionEntity getAccion() {
		return accion;
	}

	public void setAccion(AccionEntity accion) {
		this.accion = accion;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getMarcaTemporal() {
		return marcaTemporal;
	}

	public void setMarcaTemporal(Date marcaTemporal) {
		this.marcaTemporal = marcaTemporal;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}	

	
	
}
