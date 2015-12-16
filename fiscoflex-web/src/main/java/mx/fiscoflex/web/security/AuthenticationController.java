package mx.fiscoflex.web.security;

import mx.fiscoflex.api.CredencialesInvalidasException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController{

	@RequestMapping(value = "/auth",method = RequestMethod.GET)
	public String index(Model model){
		return "Authentication";
	}
	
	@RequestMapping(value = "/authentication",method = RequestMethod.POST)
	public String Auth(Model model) throws CredencialesInvalidasException{
		throw new CredencialesInvalidasException();
		//return "/Authentication";
	}
}