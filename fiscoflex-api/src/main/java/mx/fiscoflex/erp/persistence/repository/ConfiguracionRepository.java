package mx.fiscoflex.erp.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.erp.persistence.model.Configuracion;

public class ConfiguracionRepository {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public Configuracion configuracionPorId(String idConfiguracion) {
		return entityManager.createQuery("FROM Configuracion c WHERE c.id = :id", Configuracion.class)
				.setParameter("id", idConfiguracion.toString())
				.getSingleResult();
	}
}
