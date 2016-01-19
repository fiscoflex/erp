package mx.fiscoflex.rs.core.login;

import java.util.Date;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import mx.fiscoflex.rs.exception.BusinessException;
import mx.fiscoflex.rs.exception.CredencialesValidasException;
import mx.fiscoflex.rs.model.Configuracion;
import mx.fiscoflex.rs.model.Token;
import mx.fiscoflex.rs.model.Usuario;
import mx.fiscoflex.rs.repository.ConfiguracionRepositoryImpl;
import mx.fiscoflex.rs.repository.TokenRepositoryImpl;
import mx.fiscoflex.rs.repository.UsuarioRepositoryImpl;
import mx.fiscoflex.rs.util.Crypto;

@Stateless
public class AuthService {

	@Inject
	private TokenRepositoryImpl tokenQuery;

	@Inject
	private UsuarioRepositoryImpl usuarioQuery;

	@Inject
	private ConfiguracionRepositoryImpl configuracionQuery;

	public String login(LoginDTO loginDTO) throws CredencialesValidasException{

		String nombreUsuario = loginDTO.getNombre();
		String password = loginDTO.getPassword();

		if (nombreUsuario == null || nombreUsuario.length() == 0) {
			throw new BusinessException("El nombre es requerido");
		}

		if (password == null || password.length() == 0) {
			throw new BusinessException("El password es requerido");
		}

		boolean credencialesValidas = true;
		Usuario usuarioEntity = null;
		try {
			usuarioEntity = usuarioQuery.consultarUsuarioPorNombre(nombreUsuario);
		} catch (NoResultException ex) {
			credencialesValidas = false;
		}
System.out.println("password " + password);
		// Validamos el password
		String hashPassword = Crypto.hmac(password);
		System.out.println("hash " + hashPassword);
		// Último password correcto
			Usuario usuario = usuarioQuery.consultarUsuarioPorNombre(nombreUsuario);
			credencialesValidas = usuario.getPassword().equals(hashPassword);
			
		if (!credencialesValidas) {
			throw new CredencialesValidasException("Las credenciales no son validas");
		}
		
		if (!usuarioEntity.getActivo()) {
			throw new CredencialesValidasException("El usuario esta inactivo");
		}

		// Fecha y Hora
		Date fechaCreacion = DateTime.now().toDate();
		// Token automático
		String token = RandomStringUtils.randomAlphanumeric(20);
		// Encriptar el token en automático
		String hashToken = Crypto.hmac(token);
		// Consultar las horas de duración del token
		Configuracion configuracionEntity = configuracionQuery
				.consultarPorKey(ConfiguracionConst.DURACION_TOKENS);
		Integer horas = Integer.parseInt(configuracionEntity.getValor());
		// Fecha de expiración = Fecha creación más horas
		Date fechaExpiracion = new DateTime(fechaCreacion).plusHours(horas).toDate();
		
		String idToken = UUID.randomUUID().toString();
		
		// Crear y guardar el has del token
		Token nuevoToken = new Token();
		nuevoToken.setIdToken(idToken);
		nuevoToken.setIdUsuario(usuarioEntity);
		nuevoToken.setFechaCreacion(fechaCreacion);
		nuevoToken.setFechaExpiracion(fechaExpiracion);
		nuevoToken.setToken(hashToken);

		tokenQuery.guardar(nuevoToken);
		return token;
	}

	public void cerrarSesion(String token) {
		String hasToken = Crypto.hmac(token);
		Token tokenEntity = null;
		try {
			tokenEntity = tokenQuery.consultarToken(hasToken);
			tokenEntity.setActivo(false);
			tokenQuery.actualizar(tokenEntity);
		} catch (NoResultException ex) {

		}
	}

	public String nombreUsuario(String token) {
		String nombreUsuario = null;
		try {
			String hashToken = Crypto.hmac(token);
			Token tokenEntity = null;
			tokenEntity = tokenQuery.consultarToken(hashToken);
			nombreUsuario = tokenEntity.getIdUsuario().getNombre();
		} catch (NoResultException ex) {

		}
		if (nombreUsuario == null) {
			throw new BusinessException("Token invalido");
		}
		return nombreUsuario;
	}
}