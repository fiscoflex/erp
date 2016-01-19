package mx.fiscoflex.sdk.cuentacontable;

import java.util.List;

import mx.fiscoflex.sdk.webapi.ApiContext;

public class CuentaContableService {

    private ApiContext apiContext;

    public CuentaContableService() {
		
	}
	
    public CuentaContableService(ApiContext apiContext) {
		this.apiContext = apiContext;
    }
    
    public List<CuentaContableDTO> cuentaContables() {
    	return null;
    }
}
