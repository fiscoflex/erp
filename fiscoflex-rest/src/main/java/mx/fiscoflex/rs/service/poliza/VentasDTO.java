package mx.fiscoflex.rs.service.poliza;

public class VentasDTO{
	
	private Integer Folio;
	private String  RFC;
	private String  RazonSocial;
	private String  Fecha;
	private Double  Importe;
	private String  Almacen;
	
	public Integer getFolio() {
		return Folio;
	}
	public void setFolio(Integer folio) {
		Folio = folio;
	}
	public String getRFC() {
		return RFC;
	}
	public void setRFC(String rFC) {
		RFC = rFC;
	}
	public String getRazonSocial() {
		return RazonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public Double getImporte() {
		return Importe;
	}
	public void setImporte(Double importe) {
		Importe = importe;
	}
	public String getAlmacen() {
		return Almacen;
	}
	public void setAlmacen(String almacen) {
		Almacen = almacen;
	}
}
