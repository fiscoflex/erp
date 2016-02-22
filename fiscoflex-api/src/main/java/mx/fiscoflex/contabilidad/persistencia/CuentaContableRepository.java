package mx.fiscoflex.contabilidad.persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CuentaContableRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;

	/**
	 * Método que permite aguardar y actualizar registros
	 * 
	 * @param cuentaContableEntity
	 */
	public void guardarCuentaContable(CuentaContableEntity cuentaContableEntity) {
		entityManager.persist(cuentaContableEntity);
	}

	/**
	 * Método para obtener una cuenta contable
	 * 
	 * @param id
	 * @return
	 */
	public CuentaContableEntity obtenerCuentaContableporId(Integer id) {
		CuentaContableEntity cuentaContableEntity = new CuentaContableEntity();
		cuentaContableEntity = entityManager.find(CuentaContableEntity.class, id);
		return cuentaContableEntity;
	}

	/**
	 * Método para obtener la lista de cuentas contables
	 * 
	 * @return
	 */
	public List<CuentaContableEntity> obtenerCuentas() {
		List<CuentaContableEntity> list;
		list = entityManager.createQuery("SELECT a FROM CuentaContableEntity a WHERE a.cuentaPadre is NULL",
				CuentaContableEntity.class).getResultList();
		return list;
	}

	/**
	 * Método para eliminar una cuenta contable
	 * 
	 * @param id
	 */
	public void borrarCuentaContable(Integer id) {
		CuentaContableEntity cuentaContaEntity = entityManager.find(CuentaContableEntity.class, id);
		entityManager.remove(cuentaContaEntity);
	}

	/**
	 * Método para actualizar una cuenta contable
	 * 
	 * @param cuentaContableEntity
	 */
	@SuppressWarnings("unused")
	public void actualizarCuentaContable(CuentaContableEntity cuentaContableEntity) {
		CuentaContableEntity cuentaContaEntity = entityManager.find(CuentaContableEntity.class,
				cuentaContableEntity.getIdCuentaContable());
		entityManager.merge(cuentaContableEntity);
	}
}