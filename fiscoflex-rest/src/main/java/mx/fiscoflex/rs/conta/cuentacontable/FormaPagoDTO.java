package mx.fiscoflex.rs.conta.cuentacontable;

public class FormaPagoDTO {

	private Integer IdPago;
	private String TipoPago;
	private Double Importe;
	private String Banco;
	private String Cuenta;
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
