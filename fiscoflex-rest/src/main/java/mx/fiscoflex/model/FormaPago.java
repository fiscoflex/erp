package mx.fiscoflex.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="formapago")
public class FormaPago implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idformapago")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdPago;
	
	@Column(name="tipopago")
	private String TipoPago;
	
	@Column(name="importe")
	private Double Importe;
	
	@Column(name="banco")
	private String Banco;
	
	@Column(name="cuenta")
	private String Cuenta;
	
	@Column(name="referencia")
	private String Referencia;
	
	public Integer getIdPago() {
		return IdPago;
	}

	public void setIdPago(Integer idPago) {
		IdPago = idPago;
	}

	public String getTipoPago() {
		return TipoPago;
	}

	public void setTipoPago(String tipoPago) {
		TipoPago = tipoPago;
	}

	public Double getImporte() {
		return Importe;
	}

	public void setImporte(Double importe) {
		Importe = importe;
	}

	public String getBanco() {
		return Banco;
	}

	public void setBanco(String banco) {
		Banco = banco;
	}

	public String getCuenta() {
		return Cuenta;
	}

	public void setCuenta(String cuenta) {
		Cuenta = cuenta;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}	
}	
