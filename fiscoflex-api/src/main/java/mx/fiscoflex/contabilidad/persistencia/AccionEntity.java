package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Accion")
public class AccionEntity {

	@Id
	@Column(name="IdAccion")
	private String idAccion;
		
	@Column(name="Accion")
	private String accion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdComponente")
	private ComponenteEntity componente;

	public String getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(String idAccion) {
		this.idAccion = idAccion;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public ComponenteEntity getComponente() {
		return componente;
	}

	public void setComponente(ComponenteEntity componente) {
		this.componente = componente;
	}

	
	
}
