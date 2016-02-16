package mx.fiscoflex.contabilidad.bd.contabilidad;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.contabilidad.bd.contabilidad.Venta;

@Stateless
public class VentaRepositoryImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;

	public void crearVenta(Venta ventaEntity) {
		entityManager.persist(ventaEntity);
	}

	public Venta obtenerVenta(Integer id) {
		Venta ventaEntity = new Venta();
		ventaEntity = entityManager.find(Venta.class, id);
		return ventaEntity;
	}

	public List<Venta> obtenerVentas() {
		List<Venta> listaVentaEntities;
		listaVentaEntities = entityManager.createQuery("SELECT a FROM VentasEntity a", Venta.class)
				.getResultList();
		return listaVentaEntities;
	}

	public void borrarVenta(Integer id) {
		Venta ventaEntity = entityManager.find(Venta.class, id);
		entityManager.remove(ventaEntity);
	}

	@SuppressWarnings("unused")
	public void actualizarVenta(Venta ventaEntity) {
		Venta venta = entityManager.find(Venta.class, ventaEntity.getFolio());
		entityManager.merge(ventaEntity);
	}

}
