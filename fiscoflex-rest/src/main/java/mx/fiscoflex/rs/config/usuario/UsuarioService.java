package mx.fiscoflex.rs.config.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.transaction.UserTransaction;

import mx.fiscoflex.rs.exception.BusinessException;
import mx.fiscoflex.rs.persistence.UsuarioEntity;
import mx.fiscoflex.rs.persistence.UsuarioQuery;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class UsuarioService {

	@Inject
	UsuarioQuery usuarioQuery;

	@Resource
	EJBContext context;

	public void crearUsuario(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		UserTransaction userTransaction = context.getUserTransaction();
		try {
			userTransaction.begin();
			usuarioEntity.setNombre(usuario.getNombre());
			usuarioEntity.setEmail(usuario.getEmail());
			usuarioEntity.setPassword(usuario.getPassword());
			usuarioEntity.setActivo(usuario.getActivo());
			usuarioEntity.setIdPerfil(usuario.getIdPerfil());
			usuarioQuery.guardar(usuarioEntity);
			userTransaction.commit();
		} catch (PersistenceException ex) {
			throw new BusinessException("Error al crear el usuario");
		} catch (Exception ex) {
			try {
				userTransaction.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public UsuarioDTO obtenerUsuario(String nombre) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		UserTransaction userTransaction = context.getUserTransaction();
		try {
			userTransaction.begin();
			UsuarioEntity usuarioEntity = usuarioQuery.consultarUsuarioPorNombre(nombre);
			usuarioDTO.setNombre(usuarioEntity.getNombre());
			usuarioDTO.setEmail(usuarioEntity.getEmail());
			usuarioDTO.setPassword(usuarioEntity.getPassword());
			usuarioDTO.setActivo(usuarioEntity.getActivo());
			usuarioDTO.setIdPerfil(usuarioEntity.getIdPerfil());
			userTransaction.commit();
			return usuarioDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No existe el usuario buscado.");
		} catch (Exception ex) {
			try {
				userTransaction.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return usuarioDTO;
	}

	public void borrarUsuario(Integer id) {
		UserTransaction userTransaction = context.getUserTransaction();
		try {
			userTransaction.begin();
			usuarioQuery.eliminar(id);
			userTransaction.commit();
		} catch (NoResultException ex) {
			throw new BusinessException("No existe el usuario a eliminar");
		} catch (Exception ex) {
			try {
				userTransaction.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void actualizarUsuario(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		UserTransaction userTransaction = context.getUserTransaction();
		try {
			userTransaction.begin();
			usuarioEntity.setNombre(usuarioDTO.getNombre());
			usuarioEntity.setEmail(usuarioDTO.getEmail());
			usuarioEntity.setPassword(usuarioDTO.getPassword());
			usuarioEntity.setActivo(usuarioDTO.getActivo());
			usuarioEntity.setIdPerfil(usuarioDTO.getIdPerfil());
			usuarioQuery.editar(usuarioEntity);
			userTransaction.commit();
		} catch (PersistenceException ex) {
			throw new BusinessException("Error al actualizar el usuario");
		} catch (Exception ex) {
			try {
				userTransaction.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public List<UsuarioDTO> listaUsuarios() {
		List<UsuarioDTO> listaDTO = new ArrayList<UsuarioDTO>();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			List<UsuarioEntity> listaUsuarioEntities = usuarioQuery.obtenerUsuarios();
			for (UsuarioEntity usuario : listaUsuarioEntities) {
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				usuarioDTO.setNombre(usuario.getNombre());
				usuarioDTO.setEmail(usuario.getEmail());
				usuarioDTO.setActivo(usuario.getActivo());
				listaDTO.add(usuarioDTO);
			}
			utx.commit();
			return listaDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return listaDTO;
	}

}