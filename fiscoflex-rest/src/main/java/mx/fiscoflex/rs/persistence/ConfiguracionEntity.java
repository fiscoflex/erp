package mx.fiscoflex.rs.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ConfiguracionesGlobales")
public class ConfiguracionEntity {

	@Id
	@Column(name = "IdConfiguracionGlobal")
	private String clave;

	@Column(name = "Valor")
	private String valor;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}