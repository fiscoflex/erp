package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AccionRepository {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
		
	
	public AccionEntity accionPorId(String idAccion) {
		AccionEntity evento = entityManager
				.createQuery("FROM AccionEntity a WHERE a.idAccion = :idAccion", AccionEntity.class)
				.setParameter("idAccion", idAccion).getSingleResult();
		return evento;
	}
}
