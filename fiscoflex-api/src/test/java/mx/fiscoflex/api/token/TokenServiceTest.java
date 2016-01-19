package mx.fiscoflex.api.token;

import mx.fiscoflex.api.apicontext.ApiContext;
import mx.fiscoflex.api.token.TokenService;

public class TokenServiceTest {

	public static void main(String args[]) {
		ApiContext apiContext = new ApiContext();
		apiContext.setBaseUrl("http://localhost:8080/fiscoflex-api");
		TokenService authService = new TokenService(apiContext);
		
		String usuario = "admin";
		String password = "admin";
		
		String token = authService.login(usuario, password);
		
		System.out.println("Token: "  + token);
	}
}
