package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SesionRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public SesionEntity sesionPorId(String idSesion) {
		SesionEntity sesion = entityManager
				.createQuery("FROM Sesion s WHERE s.idSesion = :idSesion", SesionEntity.class)
				.setParameter("idSesion", idSesion).getSingleResult();
		return sesion;
	}
	
	public void guardar(SesionEntity sesion) {
		entityManager.persist(sesion);
	}
}
