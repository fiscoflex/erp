package mx.fiscoflex.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.model.Token;

public class TokenRepositoryImpl {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;

	public Token consultarToken(String token) {
		Token tokenEntity = entityManager
				.createQuery("FROM TokenEntity t WHERE t.token = :token", Token.class)
				.setParameter("token", token).getSingleResult();
		return tokenEntity;
	}

	public void guardar(Token token) {
		entityManager.persist(token);
	}

	public void actualizar(Token token) {
		entityManager.merge(token);
	}

	public void eliminar(Token token) {
		Token tokenEntity = entityManager.find(Token.class, token);
		entityManager.remove(tokenEntity);
	}
}