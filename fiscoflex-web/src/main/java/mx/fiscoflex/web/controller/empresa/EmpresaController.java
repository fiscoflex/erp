package mx.fiscoflex.web.controller.empresa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpresaController {

	@RequestMapping(value = "empresa", method = RequestMethod.GET)
	public String empresas() {
		return "empresa";
	}
	
	
}
