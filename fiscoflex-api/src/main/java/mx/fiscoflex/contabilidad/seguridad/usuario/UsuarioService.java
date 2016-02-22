package mx.fiscoflex.contabilidad.seguridad.usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.fiscoflex.contabilidad.persistencia.UsuarioEntity;
import mx.fiscoflex.contabilidad.persistencia.UsuarioRepository;
import mx.fiscoflex.contabilidad.seguridad.autenticacion.ContextoSeguridad;
import mx.fiscoflex.contabilidad.seguridad.bitacora.Bitacora;
import mx.fiscoflex.contabilidad.seguridad.bitacora.BitacoraService;
import mx.fiscoflex.contabilidad.util.Crypto;

@Stateless
public class UsuarioService {

	@Inject
	private BitacoraService bitacoraService;
	
	private UsuarioRepository usuarioRepository;
	
	public String usuario(String token) {
		return null;
	}
	
	public void registrarUsuario(RegistrarUsuarioDTO registrarUsuarioDTO, ContextoSeguridad sesionDTO) {
		
		
		
		Bitacora bitacoraDTO = new Bitacora();
		
	}
	
	public boolean validarPermiso(String nombreUsuario, String permiso) {
		
		return true;
	}
	
	public void crearUsuario(ResumenUsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setIdUsuario(usuario.getIdUsuario());
		usuarioEntity.setNombreUsuario(usuario.getNombre());
		usuarioEntity.setEmail(usuario.getEmail());
		usuarioEntity.setPassword(Crypto.hmac(usuario.getPassword()));
		usuarioEntity.setActivo(usuario.getActivo());
	//	usuarioEntity.setIdPerfil(usuario.getIdPerfil());
	//	usuarioQuery.guardar(usuarioEntity);
	}

	public void cambiar(CambiarPasswordDTO cambioPasswordDTO) {
		
		UsuarioEntity usuario = usuarioRepository.usuarioPorNombre(cambioPasswordDTO.getNombreUsuario());
		
		String hashPassword = Crypto.hmac(cambioPasswordDTO.getNuevoPassword());		
		usuario.setPassword(hashPassword);
		
		usuarioRepository.guardar(usuario);		
	}
}
