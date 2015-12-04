package mx.fiscoflex.rs.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TokenQuery {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;

	public TokenEntity consultarToken(String token) {
		TokenEntity tokenEntity = entityManager
				.createQuery("FROM TokenEntity t WHERE t.token = :token", TokenEntity.class)
				.setParameter("token", token).getSingleResult();
		return tokenEntity;
	}

	public void guardar(TokenEntity token) {
		entityManager.persist(token);
	}

	public void actualizar(TokenEntity token) {
		entityManager.merge(token);
	}

	public void eliminar(TokenEntity token) {
		TokenEntity tokenEntity = entityManager.find(TokenEntity.class, token);
		entityManager.remove(tokenEntity);
	}
}