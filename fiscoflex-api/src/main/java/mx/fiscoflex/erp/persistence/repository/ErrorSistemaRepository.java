package mx.fiscoflex.erp.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.erp.persistence.model.ErrorSistema;

public class ErrorSistemaRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public ErrorSistema errorSistemaPorId(String idErrorSistema) {
		ErrorSistema errorSistema = entityManager
				.createQuery("FROM ErrorSistema e WHERE e.idErrorSistema = :idErrorSistema", ErrorSistema.class)
				.setParameter("idErrorSistema", idErrorSistema).getSingleResult();
		return errorSistema;
	}
}
