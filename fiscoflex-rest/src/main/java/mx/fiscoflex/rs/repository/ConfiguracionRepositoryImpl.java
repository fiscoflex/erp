package mx.fiscoflex.rs.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.rs.model.Configuracion;

public class ConfiguracionRepositoryImpl {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public Configuracion consultarPorKey(String idConfiguracion) {
		return entityManager.createQuery("FROM ConfiguracionEntity c WHERE c.id = :id", Configuracion.class)
				.setParameter("id", idConfiguracion.toString())
				.getSingleResult();
	}
}
