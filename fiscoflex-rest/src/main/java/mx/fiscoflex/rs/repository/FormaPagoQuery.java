package mx.fiscoflex.rs.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.rs.model.FormaPago;

public class FormaPagoQuery implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	/**
	 * Método que permite aguardar  y actualizar registro
	 * @param cuentaContableEntity
	 */
	public void guardar(FormaPago formaPagoEntity) {
		entityManager.persist(formaPagoEntity);
	}
	
	/**
	 * Método que permite obtener un registro mediante id
	 * @param id
	 * @return
	 */
	public FormaPago obtenerFormaPagoId(Integer id) {
		FormaPago formaPagoEntity= new FormaPago();
		formaPagoEntity = entityManager.find(FormaPago.class,id );
		return formaPagoEntity;
	}
	
	/**
	 * Método que elimina un registro
	 * @param id
	 */
	public void eliminar(Integer id){
		FormaPago formaPagoEntity= new FormaPago();
		formaPagoEntity = entityManager.find(FormaPago.class, id);
		entityManager.remove(formaPagoEntity);
	}
	
	/**
	 *Método que regresa la lista con todos los registros 
	 * @return
	 */
	public List<FormaPago> allFormasPago() {
		List<FormaPago> list;
		list = entityManager.createQuery("SELECT a FROM FormaPagoEntity a", FormaPago.class).getResultList();
		return list;
	}
}