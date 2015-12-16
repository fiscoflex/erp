package mx.fiscoflex.api;

public class CredencialesInvalidasException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CredencialesInvalidasException() {
		super();
	}

	public CredencialesInvalidasException(String message) {
		super(message);
	}

}