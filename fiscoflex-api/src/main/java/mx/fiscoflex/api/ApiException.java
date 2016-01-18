package mx.fiscoflex.api;

public class ApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorMessage errorMessage;

	public ApiException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApiException(ErrorMessage errorMessage) {
		super(errorMessage.toString());
		
		this.errorMessage = errorMessage;
	}	

	public ApiException(Exception ex) {
		super(ex);		
	}

	public ApiException(String string) {
		super(string);
	}

	public ApiException(String message, Exception ex) {
		super(message, ex);
	}

	public ErrorMessage getError() {
		return errorMessage;
	}
	
}
