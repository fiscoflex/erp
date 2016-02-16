package mx.fiscoflex.erp.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ErrorSistema")
public class ErrorSistema {

	@Id
	@Column(name = "IdErrorSistema")
	private String idErrorSistema;
	
	@Column(name = "mensaje")
	private String mensaje;

	public String getIdErrorSistema() {
		return idErrorSistema;
	}

	public void setIdErrorSistema(String idErrorSistema) {
		this.idErrorSistema = idErrorSistema;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	

	
	
}
