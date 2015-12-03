package mx.fiscoflex.rs.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class VentaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idventa")
	private Integer IdVenta;
	
	@Column(name="folio")
	private Integer Folio;
	
	@Column(name="RFC")
	private String RFC;
	
	@Column(name="razonsocial")
	private String RazonSocial;
	
	@Column(name="fecha")
	private String Fecha;
	
	@Column(name="importe")
	private Double Importe;

	@Column(name="almacen")
	private String Almacen;
	
	public Integer getIdVenta() {
		return IdVenta;
	}
	
	public void setIdVenta(Integer idVenta) {
		IdVenta = idVenta;
	}
	
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