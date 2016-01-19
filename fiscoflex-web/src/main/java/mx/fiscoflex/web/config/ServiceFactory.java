package mx.fiscoflex.web.config;

import mx.fiscoflex.sdk.token.TokenService;
import mx.fiscoflex.sdk.webapi.ApiContext;

public class ServiceFactory {

	public TokenService getTokenService() {
		ApiContext apiContext = new ApiContext();
		
		
		TokenService tokenService = new TokenService(apiContext);
		return tokenService;
	}
}
