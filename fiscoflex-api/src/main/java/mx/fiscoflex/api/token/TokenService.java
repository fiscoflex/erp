package mx.fiscoflex.api.token;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import mx.fiscoflex.api.apicontext.ApiContext;
import mx.fiscoflex.api.apicontext.ApiException;
import mx.fiscoflex.api.apicontext.ResponseValidator;

public class TokenService {

	private ApiContext apiContext;
	
	public TokenService() {
		
	}
	
    public TokenService(ApiContext apiContext) {
		this.apiContext = apiContext;
    }
   
    public String login(String usuario, String password) {
    	try {
    	
	    	String url = apiContext.getBaseUrl() + "/auth";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(url);
			Gson gson = new Gson();
	
			String body = "{\"nombre\":\"" + usuario + "\", \"password\":\"" + password + "\"}";
			
			StringEntity input = new StringEntity(body);
			input.setContentType("application/json");
			postRequest.setEntity(input);
			
			HttpResponse httpResponse;
			httpResponse = httpClient.execute(postRequest);
			
			ResponseValidator.validate(httpResponse);
	
			String responseMessage = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		//	System.out.println(responseMessage);
			
			String token = gson.fromJson(responseMessage, String.class);
			
			return token;
    	} catch(Exception ex) {
    		
			if(ex instanceof ApiException) {
				  ApiException apiException = ((ApiException) ex);
				  throw apiException;
			}
			
			throw new ApiException("Error inesperado", ex);
    	}		
    }
}
