package mx.fiscoflex.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class Fiscoflex {

	private String token;

	public String login(Usuario usuario) {
		try {
			String url = "http://localhost:8080" + "/fiscoflexrest/auth";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(url);
			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");
			Gson gson = new Gson();

			StringEntity input = new StringEntity(gson.toJson(usuario));
			input.setContentType("application/json");
			postRequest.setEntity(input);
			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");

			HttpResponse httpResponse;
			httpResponse = httpClient.execute(postRequest);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("statusCode:: " + statusCode);

			credencialesValidas(statusCode);
			accesoDenegado(statusCode);
			errorInesperado(statusCode);

			if (statusCode == 200) {
				String responseMessage = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				String response = gson.fromJson(responseMessage, String.class);
				token = response;
				return response;
			} else {

				throw new ErrorInesperadoException();
			}

		} catch (CredencialesInvalidasException e) {
			throw new CredencialesInvalidasException();

		} catch (Exception ex) {
			throw new ErrorInesperadoException();
		}
	}

	private void credencialesValidas(Integer statusCode) {
		if (statusCode == 401) {
			System.out.println("Error :: 401");
			throw new CredencialesInvalidasException();
		}
	}

	private void accesoDenegado(Integer statusCode) {
		if (statusCode == 403) {
			System.out.println("Error 403 ::");
			throw new AccesoDenegadoException();
		}
	}

	private void errorInesperado(Integer statusCode) {
		if (statusCode == 400) {
			System.out.println("Error 400 ::");
			throw new ReglaNegocioException();
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}