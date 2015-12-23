package mx.fiscoflex.web.contabilidad;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.fiscoflex.api.CuentaContable;
import mx.fiscoflex.api.Fiscoflex;

@Controller
public class CuentaContableController {

	@RequestMapping(value = "CuentasContables", method = RequestMethod.GET)
	public String cuentasContables() {
		return "CuentasContables";
	}

	@RequestMapping(value = "cuentas", method = RequestMethod.GET)
	@ResponseBody
	public List<CuentaContable> list() {
		Fiscoflex fisco = new Fiscoflex();
		List<CuentaContable> lista = new ArrayList<CuentaContable>();
		lista = fisco.cuentas();
		return lista;
	}

	@RequestMapping(value = "crearCuenta", method = RequestMethod.POST)
	public String crearCuentaContable(HttpServletRequest request) {
		Fiscoflex fisco = new Fiscoflex();
		CuentaContable cuenta = new CuentaContable();
		cuenta.setNombreCuenta(request.getParameter("nombreCuenta"));
		cuenta.setCuentaPadre(Integer.parseInt(request.getParameter("cuentaPadre")));
		cuenta.setNaturaleza(request.getParameter("naturaleza"));
		cuenta.setEstadoFinanciero(request.getParameter("estadoFinanciero"));
		cuenta.setOrigen(request.getParameter(request.getParameter("origen")));
		cuenta.setProfundidad(Integer.parseInt(request.getParameter("profundidad")));
		fisco.crearCuenta(cuenta);
		return "CuentasContables";
	}

	@RequestMapping(value = "editarCuenta", method = RequestMethod.PUT)
	public String editarCuentaContable(HttpServletRequest request) {
		Fiscoflex fisco = new Fiscoflex();
		CuentaContable cuenta = new CuentaContable();
		cuenta.setNombreCuenta(request.getParameter("nombreCuenta"));
		cuenta.setNaturaleza(request.getParameter("naturaleza"));
		cuenta.setEstadoFinanciero(request.getParameter("estadoFinanciero"));
		cuenta.setOrigen(request.getParameter(request.getParameter("origen")));
		fisco.actualizarCuenta(cuenta);
		return "CuentasContables";
	}

}