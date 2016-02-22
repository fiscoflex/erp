package mx.fiscoflex.contabilidad.seguridad.autenticacion;

import javax.ejb.Stateless;

import mx.fiscoflex.contabilidad.exception.ApiException;
import mx.fiscoflex.contabilidad.exception.MensajeError;

@Stateless
public class ErrorAutenticacion {

	public static String ERROR_CREDENCIALES_INVALIDAS =  "E020101";
	
	public static String ERROR_USUARIO_INACTIVO =  "E020102";
	
	public static void credencialesInvalidas() {
		String mensaje = "Verifique su nombre de usuario o contraseña.";
		MensajeError errorInfo = new MensajeError();
		errorInfo.setCodigo(ERROR_CREDENCIALES_INVALIDAS);
		errorInfo.setMensaje(mensaje);
		ApiException apiException = new ApiException(errorInfo);
		throw apiException;
	}
	
	public static void usuarioInactivo() {
		String mensaje = "El usuario se encuentra inactivo.";
		MensajeError errorInfo = new MensajeError();
		errorInfo.setCodigo(ERROR_USUARIO_INACTIVO);
		errorInfo.setMensaje(mensaje);
		ApiException apiException = new ApiException(errorInfo);
		throw apiException;
	}
}
