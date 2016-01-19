package mx.fiscoflex.web.seguridad;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import mx.fiscoflex.sdk.webapi.ApiException;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AuthenticationSecurity {

	private String ajaxHeaderValue = "XMLHttpRequest";
	// private String normalHeaderValue = "text/html";
	private static final String pageLogin = "login";

	/*
	 * @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
	 * 
	 * @ExceptionHandler(LoginException.class) public void handleConflict() { //
	 * Nothing to do System.out.println("Error 401"); }
	 */

	@ResponseStatus(HttpStatus.UNAUTHORIZED) // ERROR 401
	@ExceptionHandler(ApiException.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, ApiException login) throws ApiException {
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			// System.out.println("HEADERNAME " + headerName);
			Enumeration<String> headers = req.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = headers.nextElement();
				// System.out.println("HEADERVALUE " + headerValue);
				if (headerValue.equals(ajaxHeaderValue)) {
					System.out.println("Acción ejecutada con Ajax ::");
					if (AnnotationUtils.findAnnotation(login.getClass(), ResponseStatus.class) != null) {
						throw login;
					}
				} else {
					// if (headerValue.contains(normalHeaderValue)) {
					System.out.println("Acción ejecutada normalmente redireccionando::");
					ModelAndView model = new ModelAndView();
					LoginBean loginBean = new LoginBean();
					model.addObject("loginBean", loginBean);
					model.setViewName(pageLogin);
					return model;
					// }
				}
			}
		}
		return null;
	}
}