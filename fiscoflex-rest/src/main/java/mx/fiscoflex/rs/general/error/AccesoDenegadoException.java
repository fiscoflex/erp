package mx.fiscoflex.rs.general.error;

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