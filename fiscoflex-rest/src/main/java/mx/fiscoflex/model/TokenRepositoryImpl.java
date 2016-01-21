package mx.fiscoflex.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.model.Sesion;

public class TokenRepositoryImpl {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;

	public Sesion consultarToken(String token) {
		Sesion tokenEntity = entityManager
				.createQuery("FROM TokenEntity t WHERE t.token = :token", Sesion.class)
				.setParameter("token", token).getSingleResult();
		return tokenEntity;
	}

	public void guardar(Sesion token) {
		entityManager.persist(token);
	}

	public void actualizar(Sesion token) {
		entityManager.merge(token);
	}

	public void eliminar(Sesion token) {
		Sesion tokenEntity = entityManager.find(Sesion.class, token);
		entityManager.remove(tokenEntity);
	}
}