package mx.fiscoflex.api.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.fiscoflex.api.core.model.CuentaContable;

@Entity
@Table(name = "CuentasContables")
public class CuentaContable implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCuentaContable")
	private Integer idCuentaContable;

	@Column(name = "NombreCuenta")
	private String  nombreCuenta;

	@Column(name = "CuentaPadre")
	private Integer cuentaPadre;

	@Column(name = "Naturaleza")
	private String  naturaleza;

	@Column(name = "EstadoFinanciero")
	private String  estadoFinanciero;

	@Column(name = "Origen")
	private String  origen;

	@Column(name = "Profundidad")
	private Integer profundidad;

	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn(name = "CuentaPadre", referencedColumnName = "IdCuentaContable")
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