package mx.fiscoflex.web.security;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") LoginBean login) {
		ModelAndView model = null;
		FiscoFlex fiscoflex = new FiscoFlex();
		String token = fiscoflex.obtenerToken(login.getUsername(), login.getPassword());
		if (token != null) {
			model = new ModelAndView("index");
			HttpSession session = request.getSession();
			session.setAttribute("fiscoflex", fiscoflex);
			session.setMaxInactiveInterval(30 * 60);
			session.setAttribute("URI", request.getRequestURI());
			session.setMaxInactiveInterval(30 * 60);
			Cookie cookie = new Cookie("fiscoflex.cookieId", token);
			cookie.setMaxAge(1 * 30);
			response.addCookie(cookie);
		} else {
			model = new ModelAndView("login");
			LoginBean loginBean = new LoginBean();
			model.addObject("loginBean", loginBean);
		}
		return model;
	}

	@RequestMapping("/logout")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Logout ::");
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/login");
		}
		return model;
	}

}