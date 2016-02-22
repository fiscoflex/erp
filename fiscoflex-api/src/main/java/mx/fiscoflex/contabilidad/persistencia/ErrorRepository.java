package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ErrorRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public ErrorEntity errorPorId(String idError) {
		ErrorEntity errorEntity = entityManager
				.createQuery("FROM ErrorEntity e WHERE e.idError = :idError", ErrorEntity.class)
				.setParameter("idError", idError).getSingleResult();
		return errorEntity;
	}
}
