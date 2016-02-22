package mx.fiscoflex.contabilidad.exception;

import mx.fiscoflex.contabilidad.exception.ApiException;
import mx.fiscoflex.contabilidad.exception.MensajeError;

public class ApiExceptionTest {

	public static void main(String[] args) {
		
		MensajeError mensajeError = new MensajeError();
		mensajeError.setCodigo("E010101");
		mensajeError.setMensaje("roale");
		
		ApiException apiException = new ApiException(mensajeError);
		throw apiException;
		
	}
}
