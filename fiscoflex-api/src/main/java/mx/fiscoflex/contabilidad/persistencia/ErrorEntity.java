package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Error")
public class ErrorEntity {

	@Id
	@Column(name = "IdError")
	private String idError;
	
	@Column(name = "Mensaje")
	private String mensaje;
	
	@Column(name = "Referencia")
	private String referencia;

	public String getIdError() {
		return idError;
	}

	public void setIdError(String idError) {
		this.idError = idError;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	
	
}
