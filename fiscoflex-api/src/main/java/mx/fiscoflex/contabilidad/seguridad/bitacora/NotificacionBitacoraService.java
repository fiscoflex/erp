package mx.fiscoflex.contabilidad.seguridad.bitacora;

import javax.inject.Inject;

import mx.fiscoflex.contabilidad.persistencia.BitacoraEntity;
import mx.fiscoflex.contabilidad.persistencia.BitacoraRepository;

public class NotificacionBitacoraService {

	@Inject
	private BitacoraRepository bitacoraRepository;
	
	public void notificar(String idBitacora) {
		
		BitacoraEntity bitacoraEntity = null;
		
	}
}
