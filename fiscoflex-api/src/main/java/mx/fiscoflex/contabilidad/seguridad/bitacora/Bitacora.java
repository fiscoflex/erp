package mx.fiscoflex.contabilidad.seguridad.bitacora;

import org.joda.time.DateTime;

public class Bitacora {
	
	private String idBitacora;
	
	private String idAccion;
		
	private String actividad;	
			
	private String idUsuario;

	private String nombreUsuario;
	
	private String nombreCompleto;
	
	private String ip;
	
	private DateTime fecha;
	
	private DateTime marcaTemporal;
	
	private String entrada;
	
	private String salida;

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(String idAccion) {
		this.idAccion = idAccion;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public DateTime getFecha() {
		return fecha;
	}

	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
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

	public DateTime getMarcaTemporal() {
		return marcaTemporal;
	}

	public void setMarcaTemporal(DateTime marcaTemporal) {
		this.marcaTemporal = marcaTemporal;
	}

	
}
