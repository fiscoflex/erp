package mx.fiscoflex.web.security;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String home(@ModelAttribute(value = "login") LoginBean user, HttpServletResponse response,
			HttpServletRequest request, Model model) {

		FiscoFlex fiscoflex = new FiscoFlex();
		String token = fiscoflex.obtenerToken(user.getUsername(), user.getPassword());
		String checkbox = request.getParameter("checkbox");
		if (token != null) {
			HttpSession session = request.getSession();
			session.setAttribute(ConfiguracionConst.API_NAME, fiscoflex);
			session.setMaxInactiveInterval(30 * 60);
			if (checkbox != null) {
				Cookie cookie = new Cookie(ConfiguracionConst.COOKIE_NAME, token);
				cookie.setMaxAge(30 * 30);
				response.addCookie(cookie);
			}
			return "index";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			System.out.println("Logout");
			session.invalidate();
			deleteCookieValue(response, request, ConfiguracionConst.COOKIE_NAME);
		}
		response.sendRedirect(request.getContextPath() + "/login");
	}

	public void deleteCookieValue(HttpServletResponse response, HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && name.equals(cookie.getName())) {
					Cookie invalidCookie = new Cookie(ConfiguracionConst.COOKIE_NAME, "");
					invalidCookie.setMaxAge(0);
					response.addCookie(invalidCookie);
				}
			}
		}
	}

}