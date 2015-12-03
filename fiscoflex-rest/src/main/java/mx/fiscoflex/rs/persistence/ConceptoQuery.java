package mx.fiscoflex.rs.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.rs.persistence.ConceptoEntity;

public class ConceptoQuery implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "SIAC")
	private EntityManager entityManager;

	public void crearConcepto(ConceptoEntity conceptoEntity) {
		entityManager.persist(conceptoEntity);
	}

	public ConceptoEntity obtenerConceptoPorId(Integer id) {
		ConceptoEntity conceptoEntity = new ConceptoEntity();
		conceptoEntity = entityManager.find(ConceptoEntity.class, id);
		return conceptoEntity;
	}

	public List<ConceptoEntity> obtenerListaConcepto() {
		List<ConceptoEntity> listConceptoEntity;
		listConceptoEntity = entityManager.createQuery("SELECT a FROM ConceptoEntity a", ConceptoEntity.class).getResultList();
		return listConceptoEntity;
	}

	public void borrarConcepto(Integer id) {
		ConceptoEntity conceptoEntity = entityManager.find(ConceptoEntity.class, id);
		entityManager.remove(conceptoEntity);
	}

	@SuppressWarnings("unused")
	public void actualizarConcepto(ConceptoEntity conceptoEntity) {
		ConceptoEntity cuenta = entityManager.find(ConceptoEntity.class, conceptoEntity.getIdConcepto());
		entityManager.merge(conceptoEntity);
	}
}
