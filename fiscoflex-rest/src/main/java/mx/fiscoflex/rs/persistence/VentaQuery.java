package mx.fiscoflex.rs.persistence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.rs.persistence.VentaEntity;

@Stateless
public class VentaQuery implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;

	public void crearVenta(VentaEntity ventaEntity) {
		entityManager.persist(ventaEntity);
	}

	public VentaEntity obtenerVenta(Integer id) {
		VentaEntity ventaEntity = new VentaEntity();
		ventaEntity = entityManager.find(VentaEntity.class, id);
		return ventaEntity;
	}

	public List<VentaEntity> obtenerVentas() {
		List<VentaEntity> listaVentaEntities;
		listaVentaEntities = entityManager.createQuery("SELECT a FROM VentasEntity a", VentaEntity.class)
				.getResultList();
		return listaVentaEntities;
	}

	public void borrarVenta(Integer id) {
		VentaEntity ventaEntity = entityManager.find(VentaEntity.class, id);
		entityManager.remove(ventaEntity);
	}

	@SuppressWarnings("unused")
	public void actualizarVenta(VentaEntity ventaEntity) {
		VentaEntity venta = entityManager.find(VentaEntity.class, ventaEntity.getFolio());
		entityManager.merge(ventaEntity);
	}

}
