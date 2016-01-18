package mx.fiscoflex.web.config;

import mx.fiscoflex.api.ApiContext;
import mx.fiscoflex.api.token.TokenService;

public class ServiceFactory {

	public TokenService getTokenService() {
		ApiContext apiContext = new ApiContext();
		
		
		TokenService tokenService = new TokenService(apiContext);
		return tokenService;
	}
}
