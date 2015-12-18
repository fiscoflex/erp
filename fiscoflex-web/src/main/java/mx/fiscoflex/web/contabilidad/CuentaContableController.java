package mx.fiscoflex.web.contabilidad;

import java.util.ArrayList;
import java.util.List;

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
}