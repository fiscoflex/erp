package mx.fiscoflex.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterLogin implements Filter {

	@Override
	public void init(FilterConfig init) throws ServletException {
		System.out.println("Init Filtro uno iniciado");
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession httpSession = httpRequest.getSession();
		String[] recursos = { "/bootstrap", "/dist", "/plugins" };
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		for (String array : recursos) {
			System.out.println("Recursos: " + array);
			if (path.startsWith(array)) {
				chain.doFilter(request, response);
				return;
			}
		}
		FiscoFlex fisco = (FiscoFlex) httpSession.getAttribute(ConfiguracionConst.API_NAME);
		System.out.println("FISCOFLEX SESSION ::" + fisco);
		if (fisco == null) {
			System.out.println("Obteniendo datos de sesión");
			String cookieId = getCookieValue(httpRequest, ConfiguracionConst.COOKIE_NAME);
			System.out.println("Cookie ::" + cookieId);
			if (cookieId != null) {
				System.out.println("Obteniendo Cookie" + cookieId);
				FiscoFlex fiscoFlex = new FiscoFlex();
				fiscoFlex.setToken(cookieId);
				httpSession.setAttribute("fiscoflex", fiscoFlex.getFiscoFlex());
				setCookie(httpResponse, ConfiguracionConst.COOKIE_NAME, cookieId, 30);
			} else {
				System.out.println("Redireccionando");
				httpResponse.setHeader("/jsp", httpRequest.getContextPath() + "/login");
			}
		} else {
			System.out.println("API en sesión" + fisco);
		}
		chain.doFilter(request, response);
	}

	public String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && name.equals(cookie.getName())) {
					System.out.println("Cookie :::" + cookie.getValue());
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
}