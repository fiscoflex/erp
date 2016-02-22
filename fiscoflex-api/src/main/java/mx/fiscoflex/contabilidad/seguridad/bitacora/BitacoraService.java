package mx.fiscoflex.contabilidad.seguridad.bitacora;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;

import mx.fiscoflex.contabilidad.persistencia.AccionEntity;
import mx.fiscoflex.contabilidad.persistencia.AccionRepository;
import mx.fiscoflex.contabilidad.persistencia.BitacoraEntity;
import mx.fiscoflex.contabilidad.persistencia.BitacoraRepository;
import mx.fiscoflex.contabilidad.persistencia.UsuarioEntity;
import mx.fiscoflex.contabilidad.persistencia.UsuarioRepository;
import mx.fiscoflex.contabilidad.util.IPCheck;
import mx.fiscoflex.contabilidad.util.JsonCheck;
import mx.fiscoflex.contabilidad.util.UUIDCheck;

@Stateless
public class BitacoraService {

	@Inject
	private AccionRepository accionRepository;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private BitacoraRepository bitacoraRepository;
	
	@Inject
	private ErrorBitacora errorBitacora;
	
	public void crearBitacora(Bitacora bitacora) {				
		
		String idBitacora = bitacora.getIdBitacora();
		boolean idBitacoraCampoRequerido = StringUtils.isBlank(idBitacora);
		if(idBitacoraCampoRequerido) {
			errorBitacora.idBitacoraCampoRequerido();
		}
		boolean idBitacoraFormatoInvalido = !UUIDCheck.isUUID(idBitacora);
		if(idBitacoraFormatoInvalido) {
			errorBitacora.idBitacoraFormatoInvalido();
		}		
		
		String entrada = StringUtils.trim(bitacora.getEntrada());
		
		if(!StringUtils.isBlank(entrada)) {					
			boolean entraFormatoInvalido = !JsonCheck.isJason(entrada);
			if(entraFormatoInvalido) {
				errorBitacora.entradaFormatoInvalido();
			}
		}
		
		String salida = StringUtils.trim(bitacora.getSalida());
		if(!StringUtils.isBlank(salida)) {
			boolean salidaFormatoInvalido = !JsonCheck.isJason(salida);
			
			if(salidaFormatoInvalido) {
				errorBitacora.salidaFormatoInvalido();
			}
		}
		
		String idAccion = bitacora.getIdAccion();
		boolean idAccionCampoRequerido = StringUtils.isBlank(idAccion);
		if(idAccionCampoRequerido) {
			errorBitacora.idAccionCampoRequerido();
		}
		
		String ip = bitacora.getIp();
		boolean ipCampoRequerido = StringUtils.isBlank(ip);
		if(ipCampoRequerido) {
			errorBitacora.ipCampoRequerido();
		}
		boolean ipFormatoInvalido = !IPCheck.isIP(ip);
		if(ipFormatoInvalido) {
			errorBitacora.ipFormatoInvalido();
		}
		
		String idUsuario = bitacora.getIdUsuario();
		boolean idUsuarioCampoRequerido = StringUtils.isBlank(idUsuario);
		if(idUsuarioCampoRequerido) {
			errorBitacora.idUsuarioCampoRequerido();
		} 
		
		boolean fechaCampoRequerido = null == bitacora.getFecha();
		if(fechaCampoRequerido) {
			errorBitacora.fechaCampoRequerido();			
		}
		Date fecha = bitacora.getFecha().toDate();
		
		boolean marcaTemporalCampoRequerido = null == bitacora.getMarcaTemporal();
		if(marcaTemporalCampoRequerido) {
			errorBitacora.marcaTemporalCampoRequerido();
		}
		Date marcaTemporal = bitacora.getMarcaTemporal().toDate();		
		
		
		AccionEntity accionEntity = null;
		try {
			accionEntity = accionRepository.accionPorId(idAccion);
		} catch(NoResultException ex) {
			
		}
		boolean idAccionNoExiste = accionEntity == null;
		if(idAccionNoExiste) {
			errorBitacora.idAccionNoExiste(idAccion);
		}
		
		UsuarioEntity usuarioEntity = null;
		try {
			usuarioEntity = usuarioRepository.usuarioPorId(idUsuario);
		} catch(NoResultException ex) {
			
		}
		boolean idUsuarioNoExiste = usuarioEntity == null;
		if(idUsuarioNoExiste) {
			errorBitacora.idUsuarioNoExiste(idUsuario);
		}
		
		BitacoraEntity bitacoraEntity = new BitacoraEntity();
		bitacoraEntity.setEntrada(entrada);
		bitacoraEntity.setSalida(salida);
		bitacoraEntity.setAccion(accionEntity);
		bitacoraEntity.setFecha(fecha);
		bitacoraEntity.setMarcaTemporal(marcaTemporal);
		bitacoraEntity.setIdBitacora(idBitacora);
		bitacoraEntity.setIp(ip);
		bitacoraEntity.setUsuario(usuarioEntity);
		
		bitacoraRepository.guardar(bitacoraEntity);
		
		// Dependiendo del tipo de bitacora mandar notificacion
		
	}
	
}
