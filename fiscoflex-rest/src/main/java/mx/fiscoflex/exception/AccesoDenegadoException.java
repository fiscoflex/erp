package mx.fiscoflex.exception;

public class AccesoDenegadoException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccesoDenegadoException(){
		super();
	}
	
	public AccesoDenegadoException(String message){
		super(message);
	}
	
}