package mx.fiscoflex.rs.conta.cuentacontable;

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

import mx.fiscoflex.rs.conta.cuentacontable.CuentaContableDTO;
import mx.fiscoflex.rs.exception.BusinessException;
import mx.fiscoflex.rs.persistence.CuentaContableEntity;
import mx.fiscoflex.rs.persistence.CuentaContableQuery;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class CuentaContableService {

	@Inject
	CuentaContableQuery cuentaContableQuery;

	@Resource
	EJBContext context;

	/**
	 * Método para crear una cuenta contable
	 * 
	 * @param cuentaContableDTO
	 */
	public void crearCuentaContable(CuentaContableDTO cuentaContableDTO) {
		CuentaContableEntity cuentaContableEntity = new CuentaContableEntity();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			cuentaContableEntity.setIdCuentaContable(cuentaContableDTO.getIdCuentaContable());
			cuentaContableEntity.setNombreCuenta(cuentaContableDTO.getNombreCuenta());
			cuentaContableEntity.setCuentaPadre(cuentaContableDTO.getCuentaPadre());
			cuentaContableEntity.setNaturaleza(cuentaContableDTO.getNaturaleza());
			cuentaContableEntity.setEstadoFinanciero(cuentaContableDTO.getEstadoFinanciero());
			cuentaContableEntity.setOrigen(cuentaContableDTO.getOrigen());
			cuentaContableEntity.setProfundidad(cuentaContableDTO.getProfundidad());
			cuentaContableQuery.guardarCuentaContable(cuentaContableEntity);
			utx.commit();
		} catch (PersistenceException ex) {
			throw new BusinessException("Error al crear una cuenta contable.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Método que permite editar una cuenta contable
	 * 
	 * @param cuentaContableDTO
	 */
	public void actualizarCuentaContable(CuentaContableDTO cuentaContableDTO) {
		CuentaContableEntity cuentaContableEntity = new CuentaContableEntity();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			cuentaContableEntity.setIdCuentaContable(cuentaContableDTO.getIdCuentaContable());
			cuentaContableEntity.setNombreCuenta(cuentaContableDTO.getNombreCuenta());
			cuentaContableEntity.setCuentaPadre(cuentaContableDTO.getCuentaPadre());
			cuentaContableEntity.setNaturaleza(cuentaContableDTO.getNaturaleza());
			cuentaContableEntity.setEstadoFinanciero(cuentaContableDTO.getEstadoFinanciero());
			cuentaContableEntity.setOrigen(cuentaContableDTO.getOrigen());
			cuentaContableEntity.setProfundidad(cuentaContableDTO.getProfundidad());
			cuentaContableQuery.actualizarCuentaContable(cuentaContableEntity);
			utx.commit();

		} catch (PersistenceException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Método para obtener una cuenta contable
	 * 
	 * @param id
	 * @return
	 */
	public CuentaContableDTO obtenerCuentaContable(Integer id) {
		CuentaContableDTO cuentaContableDTO = new CuentaContableDTO();
		UserTransaction utx = context.getUserTransaction();
		try {

			utx.begin();
			CuentaContableEntity cuentaContableEntity = cuentaContableQuery.obtenerCuentaContableporId(id);
			cuentaContableDTO.setIdCuentaContable(cuentaContableEntity.getIdCuentaContable());
			cuentaContableDTO.setNombreCuenta(cuentaContableEntity.getNombreCuenta());
			cuentaContableDTO.setCuentaPadre(cuentaContableEntity.getCuentaPadre());
			cuentaContableDTO.setNaturaleza(cuentaContableEntity.getNaturaleza());
			cuentaContableDTO.setEstadoFinanciero(cuentaContableEntity.getEstadoFinanciero());
			cuentaContableDTO.setOrigen(cuentaContableEntity.getOrigen());
			cuentaContableDTO.setProfundidad(cuentaContableEntity.getProfundidad());
			utx.commit();
			return cuentaContableDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return cuentaContableDTO;
	}

	/**
	 * Método para obtener la lista de cuentas contables
	 * 
	 * @return
	 */
	public List<CuentaContableDTO> listCuentaContable() {
		List<CuentaContableDTO> listCuentaDTO = new ArrayList<CuentaContableDTO>();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			List<CuentaContableEntity> listaCuentaEntities = cuentaContableQuery.obtenerCuentas();
			for (CuentaContableEntity cuenta : listaCuentaEntities) {
				listCuentaDTO.add(loadBranch(cuenta));
			}
			utx.commit();
			return listCuentaDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return listCuentaDTO;
	}

	private CuentaContableDTO loadBranch(CuentaContableEntity cuenta) {
		CuentaContableDTO cuentaContableDTO = new CuentaContableDTO();
		cuentaContableDTO.setIdCuentaContable(cuenta.getIdCuentaContable());
		cuentaContableDTO.setNombreCuenta(cuenta.getNombreCuenta());
		cuentaContableDTO.setCuentaPadre(cuenta.getCuentaPadre());
		cuentaContableDTO.setNaturaleza(cuenta.getNaturaleza());
		cuentaContableDTO.setEstadoFinanciero(cuenta.getEstadoFinanciero());
		cuentaContableDTO.setOrigen(cuenta.getOrigen());
		cuentaContableDTO.setProfundidad(cuenta.getProfundidad());
		List<CuentaContableDTO> listCuentaDTO = new ArrayList<CuentaContableDTO>();
		for (CuentaContableEntity subcuenta : cuenta.getCuentas()) {
			listCuentaDTO.add(loadBranch(subcuenta));
		}
		cuentaContableDTO.setCuentas(listCuentaDTO);
		return cuentaContableDTO;
	}

	public void borrarCuentaContable(Integer id) {
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			cuentaContableQuery.borrarCuentaContable(id);
			utx.commit();
		} catch (NoResultException ex) {
			throw new BusinessException("No exite el registro");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
	}

}