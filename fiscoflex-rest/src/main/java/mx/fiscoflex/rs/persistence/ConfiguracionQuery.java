package mx.fiscoflex.rs.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ConfiguracionQuery {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public ConfiguracionEntity consultarPorKey(String configuracionKey) {
		return entityManager.createQuery("FROM ConfiguracionEntity c WHERE c.clave = :clave", ConfiguracionEntity.class)
				.setParameter("clave", configuracionKey.toString())
				.getSingleResult();
	}
}
