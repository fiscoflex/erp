package mx.fiscoflex.rs.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.rs.persistence.FormaPagoEntity;

public class FormaPagoQuery implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "SIAC")
	private EntityManager entityManager;
	
	/**
	 * Método que permite aguardar  y actualizar registro
	 * @param cuentaContableEntity
	 */
	public void guardar(FormaPagoEntity formaPagoEntity) {
		entityManager.persist(formaPagoEntity);
	}
	
	/**
	 * Método que permite obtener un registro mediante id
	 * @param id
	 * @return
	 */
	public FormaPagoEntity obtenerFormaPagoId(Integer id) {
		FormaPagoEntity formaPagoEntity= new FormaPagoEntity();
		formaPagoEntity = entityManager.find(FormaPagoEntity.class,id );
		return formaPagoEntity;
	}
	
	/**
	 * Método que elimina un registro
	 * @param id
	 */
	public void eliminar(Integer id){
		FormaPagoEntity formaPagoEntity= new FormaPagoEntity();
		formaPagoEntity = entityManager.find(FormaPagoEntity.class, id);
		entityManager.remove(formaPagoEntity);
	}
	
	/**
	 *Método que regresa la lista con todos los registros 
	 * @return
	 */
	public List<FormaPagoEntity> allFormasPago() {
		List<FormaPagoEntity> list;
		list = entityManager.createQuery("SELECT a FROM FormaPagoEntity a", FormaPagoEntity.class).getResultList();
		return list;
	}
}