package mx.fiscoflex.contabilidad.basedatos.contabilidad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SesionRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public Sesion sesionPorId(String idSesion) {
		Sesion sesion = entityManager
				.createQuery("FROM Sesion s WHERE s.idSesion = :idSesion", Sesion.class)
				.setParameter("idSesion", idSesion).getSingleResult();
		return sesion;
	}
}
