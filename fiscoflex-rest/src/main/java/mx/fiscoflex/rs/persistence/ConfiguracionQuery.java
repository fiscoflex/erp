package mx.fiscoflex.rs.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ConfiguracionQuery {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public ConfiguracionEntity consultarPorKey(String idConfiguracion) {
		return entityManager.createQuery("FROM ConfiguracionEntity c WHERE c.id = :id", ConfiguracionEntity.class)
				.setParameter("id", idConfiguracion.toString())
				.getSingleResult();
	}
}
