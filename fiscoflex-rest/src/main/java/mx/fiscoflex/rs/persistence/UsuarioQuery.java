package mx.fiscoflex.rs.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioQuery {
	
	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public UsuarioEntity consultarUsuarioPorNombre(String nombre) {
		UsuarioEntity usuario = entityManager
				.createQuery("FROM UsuarioEntity a WHERE a.nombre = :nombre", UsuarioEntity.class)
				.setParameter("nombre", nombre).getSingleResult();
		return usuario;
	}

	public UsuarioEntity consultarPorEmail(String email) {
		UsuarioEntity usuario = entityManager
				.createQuery("FROM UsuarioEntity a WHERE a.email = :email", UsuarioEntity.class)
				.setParameter("email", email).getSingleResult();
		return usuario;
	}

	public void guardar(UsuarioEntity usuario) {
		entityManager.persist(usuario);
	}

	public void editar(UsuarioEntity usuario) {
		entityManager.merge(usuario);
	}

	public void eliminar(Integer id) {
		UsuarioEntity usuario = entityManager.find(UsuarioEntity.class, id);
		entityManager.remove(usuario);
	}

	public List<UsuarioEntity> obtenerUsuarios() {
		List<UsuarioEntity> listaUsuarios;
		listaUsuarios = entityManager.createQuery("FROM UsuarioEntity a", UsuarioEntity.class).getResultList();
		return listaUsuarios;
	}

}