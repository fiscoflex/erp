package mx.fiscoflex.rs.core.venta;

public class ConceptoDTO {

	private Integer IdConcepto;
	private Double  Cantidad;
	private String  Clave;
	private String  Descripcion;
	private Double  Costo;
	private Double  Importe;

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
