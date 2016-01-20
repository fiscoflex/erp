package mx.fiscoflex.api.usuario;

import mx.fiscoflex.api.core.model.Usuario;
import mx.fiscoflex.api.core.repository.UsuarioRepository;
import mx.fiscoflex.api.core.util.Crypto;

public class UsuarioPasswordService {

private UsuarioRepository usuarioRepository;
	
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public void cambiar(CambioPasswordDTO cambioPasswordDTO) {
		
		Usuario usuario = usuarioRepository.usuarioPorNombre(cambioPasswordDTO.getNombreUsuario());
		
		String hashPassword = Crypto.hmac(cambioPasswordDTO.getNuevoPassword());		
		usuario.setPassword(hashPassword);
		
		usuarioRepository.guardar(usuario);		
	}
}
