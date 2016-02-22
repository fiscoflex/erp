package mx.fiscoflex.contabilidad.exception;

public class ApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MensajeError mensajeError;
	
	public ApiException() {
		
	}
	
	public ApiException(MensajeError mensajeError) {	
		this.mensajeError = mensajeError;
	}
	
	public String getMessage() {
		
		String message =  "\n\tError: " + mensajeError.getCodigo() + 
			" \n\tMensaje: " + mensajeError.getMensaje() +
			" \n\tReferencia: " + mensajeError.getReferencia() + "\n";
		
		return message;
		
	}

	public MensajeError getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(MensajeError mensajeError) {
		this.mensajeError = mensajeError;
	}	

	
	

}
