package mx.fiscoflex.api.token;

public class FiscoflexAPI {

	/*
	
	private String token;
	
	public String login(String usuario, String password) {
		try {
			String url = "http://localhost:8080" + "/fiscoflexrest/auth";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(url);
			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");
			Gson gson = new Gson();

			String body = "{\"nombre\":\"" + usuario + "\", \"password\":\"" + password + "\"}";
			
			StringEntity input = new StringEntity(body);
			input.setContentType("application/json");
			postRequest.setEntity(input);
			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");

			HttpResponse httpResponse;
			httpResponse = httpClient.execute(postRequest);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();

			validar(httpResponse);

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
			throw new RuntimeException(ex);
		}
	}

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
			throw new RuntimeException(ex);
		}
	}

	public List<CuentaContableDTO> cuentas() {
		try {
			String url = "http://localhost:8080" + "/fiscoflexrest/cuentasContables/cuentas";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");
			Gson gson = new Gson();
			HttpResponse httpResponse;
			httpResponse = httpClient.execute(getRequest);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("statusCode:: " + statusCode);
			if (statusCode == 200) {
				String responseMessage = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				System.out.println(responseMessage);
				CuentaContableDTO[] array = gson.fromJson(responseMessage, CuentaContableDTO[].class);
				List<CuentaContableDTO> response = Arrays.asList(array);
				return response;
			} else {
				return new ArrayList<CuentaContableDTO>();
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public String crearCuenta(CuentaContableDTO cuentaContable) {
		try {
			String url = "http://localhost:8080" + "/fiscoflexrest/cuentasContables";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postRequest = new HttpPost(url);
			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");

			Gson gson = new Gson();

			StringEntity input = new StringEntity(gson.toJson(cuentaContable));
			input.setContentType("application/json");
			postRequest.setEntity(input);

			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");

			HttpResponse httpResponse;
			httpResponse = httpClient.execute(postRequest);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("statusCode:: " + statusCode);
			if (statusCode == 200) {
				String responseMessage = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				String response = gson.fromJson(responseMessage, String.class);

				return response;
			} else {
				return "";
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public String actualizarCuenta(CuentaContableDTO cuentaContable) {
		try {
			String url = "http://localhost:8080" + "/fiscoflexrest/cuentasContables";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPut postRequest = new HttpPut(url);
			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");

			Gson gson = new Gson();

			StringEntity input = new StringEntity(gson.toJson(cuentaContable));
			input.setContentType("application/json");
			postRequest.setEntity(input);

			postRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");

			HttpResponse httpResponse;
			httpResponse = httpClient.execute(postRequest);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("statusCode:: " + statusCode);
			if (statusCode == 200) {
				String responseMessage = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				String response = gson.fromJson(responseMessage, String.class);
				System.out.println("CUENTA ELIMINADA.....");
				return response;
			} else {
				return "";
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public String eliminarCuenta(Integer id) {
		try {
			String url = "http://localhost:8080" + "/fiscoflexrest/cuentasContables/" + id;
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpDelete getRequest = new HttpDelete(url);
			getRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");
			HttpResponse httpResponse;
			httpResponse = httpClient.execute(getRequest);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("statusCode:: " + statusCode);
			Gson gson = new Gson();
			if (statusCode == 200) {
				String responseMessage = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				String response = gson.fromJson(responseMessage, String.class);
				return response;
			} else {
				return "error";
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public CuentaContableDTO cuentaID(Integer Id) {
		CuentaContableDTO xx = null;
		try {
			String url = "http://localhost:8080" + "/fiscoflexrest/cuentasContables/numeroCuenta" + Id;
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("token", "GIFSZKYUq6emfeiffji6");
			Gson gson = new Gson();
			HttpResponse httpResponse;
			httpResponse = httpClient.execute(getRequest);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("statusCode:: " + statusCode);
			if (statusCode == 200) {
				String responseMessage = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				System.out.println(responseMessage);
				xx = gson.fromJson(responseMessage, CuentaContableDTO.class);

				return xx;
			} else {
				return xx;
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	private void validar(HttpResponse httpResponse) {
		if(httpResponse.getStatusLine().getStatusCode() == 400) {			
			try {
				String msg = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				throw new ApiException(msg);
			} catch (ParseException | IOException e) {
				throw new ApiException(e);
			}			
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
	
	*/
}