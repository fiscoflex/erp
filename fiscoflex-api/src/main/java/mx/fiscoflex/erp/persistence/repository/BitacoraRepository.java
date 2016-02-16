package mx.fiscoflex.erp.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.erp.persistence.model.Bitacora;

public class BitacoraRepository {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public void guardar(Bitacora bitacora) {
		entityManager.persist(bitacora);
	}
}
