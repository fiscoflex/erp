package mx.fiscoflex.api.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.api.core.model.Concepto;

public class ConceptoRepositoryImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;

	public void crearConcepto(Concepto conceptoEntity) {
		entityManager.persist(conceptoEntity);
	}

	public Concepto obtenerConceptoPorId(Integer id) {
		Concepto conceptoEntity = new Concepto();
		conceptoEntity = entityManager.find(Concepto.class, id);
		return conceptoEntity;
	}

	public List<Concepto> obtenerListaConcepto() {
		List<Concepto> listConceptoEntity;
		listConceptoEntity = entityManager.createQuery("SELECT a FROM ConceptoEntity a", Concepto.class).getResultList();
		return listConceptoEntity;
	}

	public void borrarConcepto(Integer id) {
		Concepto conceptoEntity = entityManager.find(Concepto.class, id);
		entityManager.remove(conceptoEntity);
	}

	@SuppressWarnings("unused")
	public void actualizarConcepto(Concepto conceptoEntity) {
		Concepto cuenta = entityManager.find(Concepto.class, conceptoEntity.getIdConcepto());
		entityManager.merge(conceptoEntity);
	}
}
