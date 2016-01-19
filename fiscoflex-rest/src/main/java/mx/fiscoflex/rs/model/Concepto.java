package mx.fiscoflex.rs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conceptos")
public class Concepto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idconcepto")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer IdConcepto;
	
	@Column(name="cantidad")
	private Double Cantidad;
	
	@Column(name="clave")
	private String Clave;
	
	@Column(name="descripcion")
	private String Descripcion;
	
	@Column(name="costo")
	private Double Costo;
	
	@Column(name="importe")
	private Double Importe;
	
	public Integer getIdConcepto() {
		return IdConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		IdConcepto = idConcepto;
	}

	public Double getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Double cantidad) {
		Cantidad = cantidad;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Double getCosto() {
		return Costo;
	}

	public void setCosto(Double costo) {
		Costo = costo;
	}

	public Double getImporte() {
		return Importe;
	}

	public void setImporte(Double importe) {
		Importe = importe;
	}
	
}
