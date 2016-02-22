package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ConfiguracionRepository {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public ConfiguracionEntity configuracionPorId(String idConfiguracion) {
		return entityManager.createQuery("FROM Configuracion c WHERE c.id = :id", ConfiguracionEntity.class)
				.setParameter("id", idConfiguracion.toString())
				.getSingleResult();
	}
}
