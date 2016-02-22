package mx.fiscoflex.contabilidad.basedatos.contabilidad;

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
	public void guardarCuentaContable(CuentaContable cuentaContableEntity) {
		entityManager.persist(cuentaContableEntity);
	}

	/**
	 * Método para obtener una cuenta contable
	 * 
	 * @param id
	 * @return
	 */
	public CuentaContable obtenerCuentaContableporId(Integer id) {
		CuentaContable cuentaContableEntity = new CuentaContable();
		cuentaContableEntity = entityManager.find(CuentaContable.class, id);
		return cuentaContableEntity;
	}

	/**
	 * Método para obtener la lista de cuentas contables
	 * 
	 * @return
	 */
	public List<CuentaContable> obtenerCuentas() {
		List<CuentaContable> list;
		list = entityManager.createQuery("SELECT a FROM CuentaContableEntity a WHERE a.cuentaPadre is NULL",
				CuentaContable.class).getResultList();
		return list;
	}

	/**
	 * Método para eliminar una cuenta contable
	 * 
	 * @param id
	 */
	public void borrarCuentaContable(Integer id) {
		CuentaContable cuentaContaEntity = entityManager.find(CuentaContable.class, id);
		entityManager.remove(cuentaContaEntity);
	}

	/**
	 * Método para actualizar una cuenta contable
	 * 
	 * @param cuentaContableEntity
	 */
	@SuppressWarnings("unused")
	public void actualizarCuentaContable(CuentaContable cuentaContableEntity) {
		CuentaContable cuentaContaEntity = entityManager.find(CuentaContable.class,
				cuentaContableEntity.getIdCuentaContable());
		entityManager.merge(cuentaContableEntity);
	}
}