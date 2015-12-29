package mx.fiscoflex.web.contabilidad;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.fiscoflex.api.CuentaContable;
import mx.fiscoflex.api.Fiscoflex;

@Controller
public class CuentaContableController {

	Fiscoflex fisco = new Fiscoflex();
	CuentaContable cuenta = new CuentaContable();

	@RequestMapping(value = "CuentasContables", method = RequestMethod.GET)
	public String cuentasContables() {
		return "CuentasContables";
	}

	@RequestMapping(value = "cuentas", method = RequestMethod.GET)
	@ResponseBody
	public List<CuentaContable> list() {
		List<CuentaContable> lista = new ArrayList<CuentaContable>();
		lista = fisco.cuentas();
		return lista;
	}

	@RequestMapping(value = "crearCuenta", method = RequestMethod.POST)
	public String crearCuentaContable(HttpServletRequest request) {
		cuenta.setNombreCuenta(request.getParameter("nombreCuenta"));
		cuenta.setCuentaPadre(Integer.parseInt(request.getParameter("cuentaPadre")));
		cuenta.setNaturaleza(request.getParameter("naturaleza"));
		cuenta.setEstadoFinanciero(request.getParameter("estadoFinanciero"));
		cuenta.setOrigen(request.getParameter("origen"));
		cuenta.setProfundidad(Integer.parseInt(request.getParameter("profundidad")));
		fisco.crearCuenta(cuenta);
		return "CuentasContables";
	}

	@RequestMapping(value = "editarCuenta", method = RequestMethod.POST)
	public String editarCuentaContable(HttpServletRequest request) {
		cuenta.setIdCuentaContable(Integer.parseInt(request.getParameter("idCuentaContableE")));
		cuenta.setNombreCuenta(request.getParameter("nombreCuentaE"));
		cuenta.setCuentaPadre(Integer.parseInt(request.getParameter("cuentaPadreE")));
		cuenta.setNaturaleza(request.getParameter("naturalezaE"));
		cuenta.setEstadoFinanciero(request.getParameter("estadoFinancieroE"));
		cuenta.setOrigen(request.getParameter("origenE"));
		cuenta.setProfundidad(Integer.parseInt(request.getParameter("profundidadE")));
		fisco.actualizarCuenta(cuenta);
		return "CuentasContables";
	}

	@RequestMapping(value = "eliminarCuenta", method = RequestMethod.POST)
	public void eliminarCuentaContable(@RequestParam String idCuenta) {
		fisco.eliminarCuenta(Integer.parseInt(idCuenta));
		//return "CuentasContables";
	}
}