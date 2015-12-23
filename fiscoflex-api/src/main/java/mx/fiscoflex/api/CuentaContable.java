package mx.fiscoflex.api;

import java.util.List;

public class CuentaContable {
	
	private Integer idCuentaContable;
	private String  nombreCuenta;
	private Integer cuentaPadre;
	private String  naturaleza;
	private String  estadoFinanciero;
	private String  origen;
	private Integer profundidad;
	private List<CuentaContable> cuentas;
	
	public Integer getIdCuentaContable() {
		return idCuentaContable;
	}
	
	public void setIdCuentaContable(Integer idCuentaContable) {
		this.idCuentaContable = idCuentaContable;
	}
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	
	public Integer getCuentaPadre() {
		return cuentaPadre;
	}
	
	public void setCuentaPadre(Integer cuentaPadre) {
		this.cuentaPadre = cuentaPadre;
	}
	
	public String getNaturaleza() {
		return naturaleza;
	}
	
	public void setNaturaleza(String naturaleza) {
		this.naturaleza = naturaleza;
	}
	
	public String getEstadoFinanciero() {
		return estadoFinanciero;
	}
	
	public void setEstadoFinanciero(String estadoFinanciero) {
		this.estadoFinanciero = estadoFinanciero;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public Integer getProfundidad() {
		return profundidad;
	}
	
	public void setProfundidad(Integer profundidad) {
		this.profundidad = profundidad;
	}
	
	public List<CuentaContable> getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(List<CuentaContable> cuentas) {
		this.cuentas = cuentas;
	}
}