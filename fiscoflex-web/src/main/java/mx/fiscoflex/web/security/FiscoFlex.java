package mx.fiscoflex.web.security;

public class FiscoFlex {

	private String token;
	private FiscoFlex fiscoFlex;
	
	public String obtenerToken(String username, String password){
		
		if(username.equals("admin") && password.equals("admin")){
			return  "admin123456";
		}else{
			return null;
		}
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public FiscoFlex getFiscoFlex() {
		return fiscoFlex;
	}
	
	public void setFiscoFlex(FiscoFlex fiscoFlex) {
		this.fiscoFlex = fiscoFlex;
	}
}