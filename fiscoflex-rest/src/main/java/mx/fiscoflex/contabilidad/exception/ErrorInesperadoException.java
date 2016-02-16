package mx.fiscoflex.contabilidad.exception;

public class ErrorInesperadoException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorInesperadoException(){
		super();
	}
	
	public ErrorInesperadoException(String message){
		super(message);
	}
}
