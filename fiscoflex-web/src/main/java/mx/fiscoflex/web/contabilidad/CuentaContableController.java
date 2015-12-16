package mx.fiscoflex.web.contabilidad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CuentaContableController {

	@RequestMapping(value = "CuentasContables", method = RequestMethod.GET)
	public String cuentasContables() {
		return "CuentasContables";
	}
}
