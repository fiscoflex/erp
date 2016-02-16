package mx.fiscoflex.rs.basedatos.contabilidad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.rs.basedatos.contabilidad.Configuracion;

public class ConfiguracionRepositoryImpl {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
	
	public Configuracion consultarPorKey(String idConfiguracion) {
		return entityManager.createQuery("FROM ConfiguracionEntity c WHERE c.id = :id", Configuracion.class)
				.setParameter("id", idConfiguracion.toString())
				.getSingleResult();
	}
}