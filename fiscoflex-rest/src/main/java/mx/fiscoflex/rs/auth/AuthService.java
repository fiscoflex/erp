package mx.fiscoflex.rs.auth;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.security.auth.login.LoginException;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import mx.fiscoflex.rs.exception.BusinessException;
import mx.fiscoflex.rs.persistence.ConfiguracionEntity;
import mx.fiscoflex.rs.persistence.ConfiguracionQuery;
import mx.fiscoflex.rs.persistence.TokenEntity;
import mx.fiscoflex.rs.persistence.TokenQuery;
import mx.fiscoflex.rs.persistence.UsuarioEntity;
import mx.fiscoflex.rs.persistence.UsuarioQuery;
import mx.fiscoflex.rs.util.Crypto;

@Stateless
public class AuthService {

	@Inject
	private TokenQuery tokenQuery;

	@Inject
	private UsuarioQuery usuarioQuery;

	@Inject
	private ConfiguracionQuery configuracionQuery;

	public String login(LoginDTO loginDTO) throws LoginException {

		String nombreUsuario = loginDTO.getNombreUsuario();
		String password = loginDTO.getPassword();

		if (nombreUsuario == null || nombreUsuario.length() == 0) {
			throw new BusinessException("El nombre es requerido");
		}

		if (password == null || password.length() == 0) {
			throw new BusinessException("El password es requerido");
		}

		boolean credencialesValidas = true;
		UsuarioEntity usuarioEntity = null;
		try {
			usuarioEntity = usuarioQuery.consultarUsuarioPorNombre(nombreUsuario);
		} catch (NoResultException ex) {
			credencialesValidas = false;
		}

		// Validamos el password
		String hashPassword = Crypto.hmac(password);
		// Último password correcto
		UsuarioEntity usuario = usuarioQuery.consultarUsuarioPorNombre(nombreUsuario);
		credencialesValidas = usuario.getPassword().equals(hashPassword);

		if (!credencialesValidas) {
			throw new LoginException("Las credenciales no son validas");
		}

		if (!usuarioEntity.getActivo()) {
			throw new LoginException("El usuario esta inactivo");
		}

		// Fecha y Hora
		Date fechaCreacion = DateTime.now().toDate();
		// Token automático
		String token = RandomStringUtils.randomAlphanumeric(20);
		// Encriptar el token en automático
		String hashToken = Crypto.hmac(token);
		// Consultar las horas de duración del token
		ConfiguracionEntity configuracionEntity = configuracionQuery
				.consultarPorKey(ConfiguracionConst.DURACION_TOKENS);
		Integer horas = Integer.parseInt(configuracionEntity.getValor());
		// Fecha de expiración = Fecha creación más horas
		Date fechaExpiracion = new DateTime(fechaCreacion).plusHours(horas).toDate();
		// Crear y guardar el has del token
		TokenEntity nuevoToken = new TokenEntity();
		nuevoToken.setIdUsuario(usuarioEntity);
		nuevoToken.setFechaCreacion(fechaCreacion);
		nuevoToken.setFechaExpiracion(fechaExpiracion);
		nuevoToken.setToken(hashToken);

		tokenQuery.guardar(nuevoToken);
		return token;
	}

	public void cerrarSesion(String token) {
		String hasToken = Crypto.hmac(token);
		TokenEntity tokenEntity = null;
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
			TokenEntity tokenEntity = null;
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