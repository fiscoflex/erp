package mx.fiscoflex.web.security;

import java.util.Enumeration;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import mx.fiscoflex.web.login.LoginBean;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class AuthenticationSecurity {
	/*
	@ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
	@ExceptionHandler(LoginException.class)
	public void handleConflict() {
	// Nothing to do
		System.out.println("Error 401");
	}
	*/
	
	@ExceptionHandler(LoginException.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        //if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
          //  throw e;
        // Otherwise setup and send the user to a default error-view.
		Enumeration<String> headerNames = req.getHeaderNames();

		while (headerNames.hasMoreElements()) {

			String headerName = headerNames.nextElement();
			System.out.println("HEADERNAME " + headerName);

			Enumeration<String> headers = req.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = headers.nextElement();
				System.out.println("HEADERVALUE " + headerValue);
			}

		}
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model; 
    }

	
}
