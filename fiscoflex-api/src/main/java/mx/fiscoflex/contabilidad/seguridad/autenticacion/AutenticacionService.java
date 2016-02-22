package mx.fiscoflex.contabilidad.seguridad.autenticacion;

import java.util.Date;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import mx.fiscoflex.contabilidad.persistencia.ConfiguracionEntity;
import mx.fiscoflex.contabilidad.persistencia.ConfiguracionRepository;
import mx.fiscoflex.contabilidad.persistencia.SesionEntity;
import mx.fiscoflex.contabilidad.persistencia.SesionRepository;
import mx.fiscoflex.contabilidad.persistencia.UsuarioEntity;
import mx.fiscoflex.contabilidad.persistencia.UsuarioRepository;
import mx.fiscoflex.contabilidad.seguridad.bitacora.Bitacora;
import mx.fiscoflex.contabilidad.seguridad.bitacora.BitacoraService;
import mx.fiscoflex.contabilidad.util.Crypto;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

@Stateless
public class AutenticacionService {
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private ConfiguracionRepository configuracionRepository;
	
	@Inject 
	private SesionRepository sesionRepository;	
	
	@Inject
	private BitacoraAutenticacion bitacoraAutenticacion;
	
	@Inject
	private BitacoraService bitacoraService;

	public ContextoSeguridad sesionActiva(String idSesion) {
				
		return null;
	}
	
	public String login(Credenciales credenciales, String ip) {			
		
		boolean credencialesInvalidas = false;
		
		String nombreUsuario = StringUtils.trim(credenciales.getNombreUsuario());
		String password = credenciales.getPassword();

		boolean nombreVacio = StringUtils.isBlank(nombreUsuario);
		boolean passwordVacio = StringUtils.isBlank(password);
		
		// Error Credenciales Invalidas
		if (nombreVacio || passwordVacio) {
			ErrorAutenticacion.credencialesInvalidas();
		}
		
		UsuarioEntity usuario = null;
		
		try {
			usuario = usuarioRepository.usuarioPorNombre(credenciales.getNombreUsuario());
		} catch (NoResultException ex) {
			credencialesInvalidas = true;
		}
		if(credencialesInvalidas) {
			ErrorAutenticacion.credencialesInvalidas();			
		}
		
		// Validamos el password
		String hashPassword = Crypto.hmac(credenciales.getPassword());

		// Ultimo password correcto		
		credencialesInvalidas = !usuario.getPassword().equals(hashPassword);
		
		// Error Credenciales Invalidas
		if(credencialesInvalidas) {
			ErrorAutenticacion.credencialesInvalidas();					
		}
		
		// Error Usuario Inactivo
		if (!usuario.getActivo()) {
		   ErrorAutenticacion.usuarioInactivo();
		}
		
		String idSesion = UUID.randomUUID().toString();
		// Fecha y Hora
		Date fechaCreacion = DateTime.now().toDate();
		// Token automAtico
		String token = RandomStringUtils.randomAlphanumeric(20);
		// Encriptar el token en automático
		String hashToken = Crypto.hmac(token);
		
		
		// Consultar las horas de duración del token
		ConfiguracionEntity configuracionEntity = configuracionRepository.configuracionPorId("DURACION_TOKENS");						
		Integer horas = Integer.parseInt(configuracionEntity.getValor());
		// Fecha de expiración = Fecha creación más horas
		Date fechaExpiracion = new DateTime(fechaCreacion).plusHours(horas).toDate();		
								
		// Crear y guardar la sesion
		SesionEntity sesionEntity = new SesionEntity();
		sesionEntity.setIdSesion(idSesion);
		sesionEntity.setToken(token);
		sesionEntity.setUsuario(usuario);
		sesionEntity.setFechaCreacion(fechaCreacion);
		sesionEntity.setFechaExpiracion(fechaExpiracion);		
		
		sesionRepository.guardar(sesionEntity);
		
		String idUsuario = sesionEntity.getUsuario().getIdUsuario();
		Bitacora bitacora = bitacoraAutenticacion.login(nombreUsuario, hashToken, ip, idUsuario);	
		
		bitacoraService.crearBitacora(bitacora);		
		
		return hashToken;			
	}
}
