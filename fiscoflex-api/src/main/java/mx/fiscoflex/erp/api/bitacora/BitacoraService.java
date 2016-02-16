package mx.fiscoflex.erp.api.bitacora;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.fiscoflex.erp.api.error.ErrorGeneral;
import mx.fiscoflex.erp.api.error.ErrorService;
import mx.fiscoflex.erp.persistence.model.Bitacora;
import mx.fiscoflex.erp.persistence.model.Evento;
import mx.fiscoflex.erp.persistence.model.Sesion;
import mx.fiscoflex.erp.persistence.repository.BitacoraRepository;
import mx.fiscoflex.erp.persistence.repository.EventoRepository;
import mx.fiscoflex.erp.persistence.repository.SesionRepository;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Stateless
public class BitacoraService {

	@Inject
	private EventoRepository eventoRepository;
	
	@Inject
	private SesionRepository sesionRepository;
	
	@Inject
	private BitacoraRepository bitacoraRepository;
	
	@Inject
	private ErrorService errorService;
	
	public void crearBitacora(BitacoraDTO bitacoraDTO) {
		
		// Al ser un componente interno los mensajes de error en caso de haberlos
		// deben ser desconocidos para el usuario E1000
		
		
		String entrada = bitacoraDTO.getEntrada();
		boolean entradaVacia = StringUtils.isEmpty(entrada);
		if(StringUtils.isEmpty(entrada)) {
			errorService.error(ErrorGeneral.DESCONOCIDO);
		}
		
		String idBitacora = bitacoraDTO.getIdBitacora();
		String ip = bitacoraDTO.getIp();
		
		Evento evento = eventoRepository.eventoPorId(bitacoraDTO.getIdEvento());
		
		DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTimeFormatter hf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		
		Date fecha = df.parseDateTime(bitacoraDTO.getFecha()).toDate();
		Date hora = hf.parseDateTime(bitacoraDTO.getFecha()).toDate(); 
		
		
		
		
		Sesion sesion = sesionRepository.sesionPorId(bitacoraDTO.getIdBitacora());
		long tiempoEjecucion = bitacoraDTO.getTiempoEjecucion();
		
		Bitacora bitacora = new Bitacora();
		bitacora.setEntrada(entrada);
		bitacora.setEvento(evento);
		bitacora.setFecha(fecha);
		bitacora.setHora(hora);
		bitacora.setIdBitacora(idBitacora);
		bitacora.setIp(ip);
		bitacora.setSesion(sesion);
		bitacora.setTiempoEjecucion(tiempoEjecucion);		
		
		bitacoraRepository.guardar(bitacora);
	}
}
