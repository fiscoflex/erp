package mx.fiscoflex.contabilidad.seguridad.bitacora;

import javax.inject.Inject;

import mx.fiscoflex.contabilidad.exception.ApiException;
import mx.fiscoflex.contabilidad.exception.MensajeError;
import mx.fiscoflex.contabilidad.persistencia.ErrorEntity;
import mx.fiscoflex.contabilidad.persistencia.ErrorRepository;

public class ErrorBitacora {
	
	public static final String ENTRADA_FORMATO_INVALIDO = "E020201";	
	
	public static final String ID_BITACORA_CAMPO_REQUERIDO = "E020202";
	
	public static final String SALIDA_FORMATO_INVALIDO = "E020203";
	
	public static final String ID_ACCION_CAMPO_REQUERIDO = "E020204";
	
	public static final String ID_USUARIO_CAMPO_REQUERIDO = "E020205";
	
	public static final String IP_CAMPO_REQUERIDO = "E020206";
	
	public static final String FECHA_CAMPO_REQUERIDO = "E020207";
	
	public static final String MARCA_TEMPORAL_CAMPO_REQUERIDO = "E020208";
	
	public static final String ID_BITACORA_FORMATO_INVALIDO = "E020209";
	
	public static final String IP_FORMATO_INVALIDO = "E020210";
	
	public static final String ID_USUARIO_NO_EXISTE = "E020211";
	
	public static final String ID_ACCION_NO_EXISTE = "E020212";
	
	@Inject
	private ErrorRepository errorRepository;
	
	public void idBitacoraCampoRequerido() {
		error(ID_BITACORA_CAMPO_REQUERIDO);
	}
	
	public void entradaFormatoInvalido() {
		error(ENTRADA_FORMATO_INVALIDO);
	}
	
	public void salidaFormatoInvalido() {
		error(SALIDA_FORMATO_INVALIDO);
	}
	
	public void idAccionCampoRequerido() {
		error(ID_ACCION_CAMPO_REQUERIDO);
	}
	
	public void idUsuarioCampoRequerido() {
		error(ID_USUARIO_CAMPO_REQUERIDO);
	}
	
	public void ipCampoRequerido() {
		error(IP_CAMPO_REQUERIDO);
	}
	
	public void fechaCampoRequerido() {
		error(FECHA_CAMPO_REQUERIDO);
	}
	
	public void marcaTemporalCampoRequerido() {
		error(MARCA_TEMPORAL_CAMPO_REQUERIDO);
	}
	
	public void idBitacoraFormatoInvalido() {
		error(ID_BITACORA_FORMATO_INVALIDO);
	}
	
	public void ipFormatoInvalido() {
		error(IP_FORMATO_INVALIDO);
	}
	
	public void idUsuarioNoExiste(String idUsuario) {
		
		ErrorEntity errorEntity = errorRepository.errorPorId(ID_USUARIO_NO_EXISTE);
		String mensaje = errorEntity.getMensaje().replace("ID_USUARIO", idUsuario);
		MensajeError mensajeError = new MensajeError();
		mensajeError.setCodigo(ID_USUARIO_NO_EXISTE);
		mensajeError.setMensaje(mensaje);
		throw new ApiException(mensajeError);
	}
	
	public void idAccionNoExiste(String idAccion) {
		
		ErrorEntity errorEntity = errorRepository.errorPorId(ID_ACCION_NO_EXISTE);
		String mensaje = errorEntity.getMensaje().replace("ID_ACCION", idAccion);
		MensajeError mensajeError = new MensajeError();
		mensajeError.setCodigo(errorEntity.getIdError());
		mensajeError.setMensaje(mensaje);
		throw new ApiException(mensajeError);
	}
	
	public ApiException error(String idError) {
		ErrorEntity errorEntity = errorRepository.errorPorId(idError);
		String mensaje = errorEntity.getMensaje();
		MensajeError mensajeError = new MensajeError();
		mensajeError.setCodigo(errorEntity.getIdError());
		mensajeError.setMensaje(mensaje);
		mensajeError.setReferencia(errorEntity.getReferencia());
		throw new ApiException(mensajeError);
	}
}


