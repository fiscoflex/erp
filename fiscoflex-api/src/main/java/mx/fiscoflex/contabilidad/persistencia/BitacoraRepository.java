package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BitacoraRepository {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public void guardar(BitacoraEntity bitacora) {
		entityManager.persist(bitacora);
	}
}
