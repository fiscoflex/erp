package mx.fiscoflex.rs.basedatos.contabilidad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.erp.persistence.model.Sesion;

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
