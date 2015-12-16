package mx.fiscoflex.rs.exception;

public class CredencialesValidasException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CredencialesValidasException(){
		super();
	}
	
	public CredencialesValidasException(String message){
		super(message);
	}
}
