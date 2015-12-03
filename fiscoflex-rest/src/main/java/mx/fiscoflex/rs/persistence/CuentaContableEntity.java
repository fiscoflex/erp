package mx.fiscoflex.rs.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.fiscoflex.rs.persistence.CuentaContableEntity;

@Entity
@Table(name = "cuentascontables")
public class CuentaContableEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idnumerocuenta")
	private Integer NumeroCuenta;

	@Column(name = "nombrecuenta")
	private String NombreCuenta;

	@Column(name = "cuentapadre")
	private Integer CuentaPadre;

	@Column(name = "naturaleza")
	private String Naturaleza;

	@Column(name = "estadofinanciero")
	private String EstadoFinanciero;

	@Column(name = "origen")
	private String Origen;

	@Column(name = "nivel")
	private Integer Nivel;

	@Column(name = "profundidad")
	private Integer Profundidad;

	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn(name = "cuentapadre", referencedColumnName = "idnumerocuenta")
	private List<CuentaContableEntity> cuentas;
	
	public Integer getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	public String getNombreCuenta() {
		return NombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		NombreCuenta = nombreCuenta;
	}

	public Integer getCuentaPadre() {
		return CuentaPadre;
	}

	public void setCuentaPadre(Integer cuentaPadre) {
		CuentaPadre = cuentaPadre;
	}

	public String getNaturaleza() {
		return Naturaleza;
	}

	public void setNaturaleza(String naturaleza) {
		Naturaleza = naturaleza;
	}

	public String getEstadoFinanciero() {
		return EstadoFinanciero;
	}

	public void setEstadoFinanciero(String estadoFinanciero) {
		EstadoFinanciero = estadoFinanciero;
	}

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}

	public Integer getNivel() {
		return Nivel;
	}

	public void setNivel(Integer nivel) {
		Nivel = nivel;
	}

	public Integer getProfundidad() {
		return Profundidad;
	}

	public void setProfundidad(Integer profundidad) {
		Profundidad = profundidad;
	}
	
	public List<CuentaContableEntity> getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(List<CuentaContableEntity> cuentas) {
		this.cuentas = cuentas;
	}
}
