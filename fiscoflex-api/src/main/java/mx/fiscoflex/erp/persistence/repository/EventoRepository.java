package mx.fiscoflex.erp.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.erp.persistence.model.Evento;

public class EventoRepository {

	@PersistenceContext(name="fiscoflexpu")
	private EntityManager entityManager;
		
	
	public Evento eventoPorId(String idEvento) {
		Evento evento = entityManager
				.createQuery("FROM Evento s WHERE s.idEvento = :idEvento", Evento.class)
				.setParameter("idEvento", idEvento).getSingleResult();
		return evento;
	}
}
