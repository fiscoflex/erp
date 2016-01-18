package mx.fiscoflex.rs.core.venta;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.transaction.UserTransaction;

import mx.fiscoflex.rs.core.venta.ConceptoDTO;
import mx.fiscoflex.rs.exception.BusinessException;
import mx.fiscoflex.rs.persistence.ConceptoEntity;
import mx.fiscoflex.rs.persistence.ConceptoQuery;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class ConceptoEJB {

	@Inject
	ConceptoQuery conceptoQuery;

	@Resource
	EJBContext context;

	public void crearConcepto(ConceptoDTO conceptoDTO) {
		ConceptoEntity conceptoEntity = new ConceptoEntity();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			conceptoEntity.setCantidad(conceptoDTO.getCantidad());
			conceptoEntity.setClave(conceptoDTO.getClave());
			conceptoEntity.setDescripcion(conceptoDTO.getDescripcion());
			conceptoEntity.setCosto(conceptoDTO.getCosto());
			conceptoEntity.setImporte(conceptoDTO.getImporte());
			conceptoQuery.crearConcepto(conceptoEntity);
			utx.commit();
		} catch (PersistenceException ex) {
			throw new BusinessException("Error al crear el concepto");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public ConceptoDTO obtenerConcepto(Integer id) {
		ConceptoDTO conceptoDTO = new ConceptoDTO();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			ConceptoEntity conceptoEntity = conceptoQuery.obtenerConceptoPorId(id);
			conceptoDTO.setCantidad(conceptoEntity.getCantidad());
			conceptoDTO.setClave(conceptoEntity.getClave());
			conceptoDTO.setDescripcion(conceptoEntity.getDescripcion());
			conceptoDTO.setCosto(conceptoEntity.getCosto());
			conceptoDTO.setImporte(conceptoEntity.getImporte());
			utx.commit();
			return conceptoDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return conceptoDTO;
	}

	public List<ConceptoDTO> listaConcepto() {
		List<ConceptoDTO> listaDTO = new ArrayList<ConceptoDTO>();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			List<ConceptoEntity> listaConceptoEntities = conceptoQuery.obtenerListaConcepto();
			for (ConceptoEntity concepto : listaConceptoEntities) {
				ConceptoDTO conceptoDTO = new ConceptoDTO();
				conceptoDTO.setCantidad(concepto.getCantidad());
				conceptoDTO.setClave(concepto.getClave());
				conceptoDTO.setDescripcion(concepto.getDescripcion());
				conceptoDTO.setCosto(concepto.getCosto());
				conceptoDTO.setImporte(concepto.getImporte());
				listaDTO.add(conceptoDTO);
			}
			utx.commit();
			return listaDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return listaDTO;
	}

	public void borrarConcepto(Integer id) {
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			conceptoQuery.borrarConcepto(id);
			utx.commit();
		} catch (NoResultException ex) {
			throw new BusinessException("No existe el concepto a eliminar");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void actualizarConcepto(ConceptoDTO conceptoDTO) {
		ConceptoEntity conceptoEntity = new ConceptoEntity();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			conceptoEntity.setIdConcepto(conceptoDTO.getIdConcepto());
			conceptoEntity.setCantidad(conceptoDTO.getCantidad());
			conceptoEntity.setClave(conceptoDTO.getClave());
			conceptoEntity.setDescripcion(conceptoDTO.getDescripcion());
			conceptoEntity.setCosto(conceptoDTO.getCosto());
			conceptoEntity.setImporte(conceptoDTO.getImporte());
			conceptoQuery.actualizarConcepto(conceptoEntity);
			utx.commit();
		} catch (PersistenceException ex) {
			throw new BusinessException("Error al actualizar el concepto");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}