package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Componente")
public class ComponenteEntity {

	@Id
	@Column(name="IdComponente")
	private String idComponente;
	
	@Column(name="Modulo")
	private String modulo;
	
	@Column(name="Componente")
	private String componente;

	public String getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(String idComponente) {
		this.idComponente = idComponente;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}
	
	
}
