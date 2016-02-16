package mx.fiscoflex.erp.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Configuracion")
public class Configuracion {

	@Id
	@Column(name = "IdConfiguracion")
	private String idConfiguracion;

	@Column(name = "Valor")
	private String valor;

	

	public String getIdConfiguracion() {
		return idConfiguracion;
	}

	public void setIdConfiguracion(String idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}