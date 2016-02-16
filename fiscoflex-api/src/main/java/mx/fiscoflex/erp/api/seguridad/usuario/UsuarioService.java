package mx.fiscoflex.erp.api.seguridad.usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.fiscoflex.erp.api.bitacora.BitacoraDTO;
import mx.fiscoflex.erp.api.bitacora.BitacoraService;
import mx.fiscoflex.erp.api.seguridad.sesion.SesionDTO;
import mx.fiscoflex.erp.persistence.model.Usuario;
import mx.fiscoflex.erp.persistence.repository.UsuarioRepository;
import mx.fiscoflex.erp.util.Crypto;

@Stateless
public class UsuarioService {

	@Inject
	private BitacoraService bitacoraService;
	
	private UsuarioRepository usuarioRepository;
	
	public String usuario(String token) {
		return null;
	}
	
	public void registrarUsuario(RegistrarUsuarioDTO registrarUsuarioDTO, SesionDTO sesionDTO) {
		
		
		
		BitacoraDTO bitacoraDTO = new BitacoraDTO();
		
	}
	
	public boolean validarPermiso(String nombreUsuario, String permiso) {
		
		return true;
	}
	
	public void crearUsuario(ResumenUsuarioDTO usuario) {
		Usuario usuarioEntity = new Usuario();
		usuarioEntity.setIdUsuario(usuario.getIdUsuario());
		usuarioEntity.setNombreUsuario(usuario.getNombre());
		usuarioEntity.setEmail(usuario.getEmail());
		usuarioEntity.setPassword(Crypto.hmac(usuario.getPassword()));
		usuarioEntity.setActivo(usuario.getActivo());
	//	usuarioEntity.setIdPerfil(usuario.getIdPerfil());
	//	usuarioQuery.guardar(usuarioEntity);
	}

	public void cambiar(CambiarPasswordDTO cambioPasswordDTO) {
		
		Usuario usuario = usuarioRepository.usuarioPorNombre(cambioPasswordDTO.getNombreUsuario());
		
		String hashPassword = Crypto.hmac(cambioPasswordDTO.getNuevoPassword());		
		usuario.setPassword(hashPassword);
		
		usuarioRepository.guardar(usuario);		
	}
}
