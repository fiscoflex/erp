package mx.fiscoflex.erp.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Evento")
public class Evento {

	@Id
	@Column(name="IdEvento")
	private String idEvento;
	
	@Column(name="Clase")
	private String clase;
	
	@Column(name="Accion")
	private String accion;
	
	@Column(name="Nivel")
	private int nivel;

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	
	
}
