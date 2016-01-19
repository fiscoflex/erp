package mx.fiscoflex.exception;

public class ReglaNegocioException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReglaNegocioException(){
		super();
	}
	
	public ReglaNegocioException(String message){
		super(message);
	}
}
