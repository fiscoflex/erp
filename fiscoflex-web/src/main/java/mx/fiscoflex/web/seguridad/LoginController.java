package mx.fiscoflex.web.seguridad;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			if (session.getAttribute(ConfiguracionConst.API_NAME) != null) {
				return "index";
			}
		}
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String home(@ModelAttribute(value = "login") LoginBean user, HttpServletResponse response,
			HttpServletRequest request, ModelMap model) {
		
		/*
		try{
			FiscoflexAPI fiscoflex = new FiscoflexAPI();
			Usuario usuario = new Usuario();
			usuario.setNombre(user.getUsername());
			usuario.setPassword(user.getPassword());
			
			String tokenRemoto = fiscoflex.login(usuario);		
			String checkbox = request.getParameter("checkbox");
			HttpSession session = request.getSession();
			
			session.setAttribute(ConfiguracionConst.API_NAME, fiscoflex);
			session.setMaxInactiveInterval(30 * 60);
			
			if (checkbox != null) {
				Cookie cookie = new Cookie(ConfiguracionConst.COOKIE_NAME, tokenRemoto);
				cookie.setMaxAge(30 * 30);
				response.addCookie(cookie);
			}
			return "index";
		}catch(CredencialesInvalidasException c){
			model.put("error", "Usuario/Password incorrectos");
			return "login";
		}
		
		*/
		
		return null;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			deleteCookieValue(response, request, ConfiguracionConst.COOKIE_NAME);
			response.sendRedirect(request.getContextPath() + "/login");
		}
		//return "login";
	}

	public void deleteCookieValue(HttpServletResponse response, HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && name.equals(cookie.getName())) {
					Cookie invalidCookie = new Cookie(ConfiguracionConst.COOKIE_NAME, null);
					invalidCookie.setMaxAge(0);
					response.addCookie(invalidCookie);
				}
			}
		}
	}

}