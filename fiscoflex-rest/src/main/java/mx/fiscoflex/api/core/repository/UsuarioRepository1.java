package mx.fiscoflex.api.core.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.api.core.model.Usuario;

public class UsuarioRepository1 {
	
	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public Usuario consultarUsuarioPorNombre(String nombre) {
		Usuario usuario = entityManager
				.createQuery("FROM UsuarioEntity a WHERE a.nombre = :nombre", Usuario.class)
				.setParameter("nombre", nombre).getSingleResult();
		return usuario;
	}

	public Usuario consultarPorEmail(String email) {
		Usuario usuario = entityManager
				.createQuery("FROM UsuarioEntity a WHERE a.email = :email", Usuario.class)
				.setParameter("email", email).getSingleResult();
		return usuario;
	}

	public void guardar(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public void editar(Usuario usuario) {
		entityManager.merge(usuario);
	}

	public void eliminar(Integer id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
	}

	public List<Usuario> obtenerUsuarios() {
		List<Usuario> listaUsuarios;
		listaUsuarios = entityManager.createQuery("FROM UsuarioEntity a", Usuario.class).getResultList();
		return listaUsuarios;
	}

}