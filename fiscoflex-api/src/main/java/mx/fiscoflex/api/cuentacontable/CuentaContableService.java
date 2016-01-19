package mx.fiscoflex.api.cuentacontable;

import java.util.List;

import mx.fiscoflex.api.apicontext.ApiContext;

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
