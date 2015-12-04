package mx.fiscoflex.rs.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.rs.persistence.CuentaContableEntity;

public class CuentaContableQuery implements Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;


	/**
	 * Método que permite aguardar y actualizar registros  
	 * @param cuentaContableEntity
	 */
	public void guardar(CuentaContableEntity cuentaContableEntity) {
		entityManager.persist(cuentaContableEntity);
	}


	/*
	 * Método que obtiene un registro de cuenta contable por id
	 */
	public CuentaContableEntity obtenerCuentaContableporId(Integer id) {
		CuentaContableEntity cuentaContableEntity = new CuentaContableEntity();
		cuentaContableEntity =  entityManager.find(CuentaContableEntity.class, id);
		return cuentaContableEntity;
	}

	/*
	 * Método que obtiene la lista de los registros de cuenta contable
	 */
	public List<CuentaContableEntity> obtenerRegistros() {
		List<CuentaContableEntity> list;
		list = entityManager.createQuery("SELECT a FROM CuentaContableEntity a", CuentaContableEntity.class).getResultList();
		return list;
	}

	/*
	 * Método que borra un registro de cuenta contable
	 */
	public void borrarRegistro(Integer id) {
		CuentaContableEntity cuentaContaEntity = entityManager.find(CuentaContableEntity.class, id);
		entityManager.remove(cuentaContaEntity);
	}
	
	/*
	 * Método que actualiza un registro de cuenta contable
	 */
	@SuppressWarnings("unused")
	public void actualizaRegistro(CuentaContableEntity cuentaContableEntity) {
		CuentaContableEntity cuentaContaEntity = entityManager.find(CuentaContableEntity.class, cuentaContableEntity.getNumeroCuenta());
		entityManager.merge(cuentaContableEntity);
	}
}