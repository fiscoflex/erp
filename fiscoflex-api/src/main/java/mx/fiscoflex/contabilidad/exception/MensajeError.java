package mx.fiscoflex.contabilidad.exception;

import java.io.Serializable;
import java.util.List;

public class MensajeError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	
	private String mensaje;
	
	private String referencia;
	
	public MensajeError() {}

	public MensajeError(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/*
	public String toString()  {
		return "{ Codigo: " + getCodigo() + " Mensaje: " + getMensaje() + "}";
	}*/

	

	 @Override
	 public String toString() {
		 return "orale puto";
	 }

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
}
