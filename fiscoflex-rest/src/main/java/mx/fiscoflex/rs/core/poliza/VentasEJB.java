package mx.fiscoflex.rs.core.poliza;

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

import mx.fiscoflex.rs.core.poliza.VentasDTO;
import mx.fiscoflex.rs.exception.BusinessException;
import mx.fiscoflex.rs.persistence.VentaEntity;
import mx.fiscoflex.rs.persistence.VentaQuery;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class VentasEJB {

	@Inject
	VentaQuery ventasQuery;

	@Resource
	EJBContext context;

	public void crear(VentasDTO ventaDTO) {
		VentaEntity ventaEntity = new VentaEntity();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			ventaEntity.setFolio(ventaDTO.getFolio());
			ventaEntity.setRFC(ventaDTO.getRFC());
			ventaEntity.setRazonSocial(ventaDTO.getRazonSocial());
			ventaEntity.setFecha(ventaDTO.getFecha());
			ventaEntity.setImporte(ventaDTO.getImporte());
			ventaEntity.setAlmacen(ventaDTO.getAlmacen());
			ventasQuery.crearVenta(ventaEntity);
			utx.commit();
		} catch (PersistenceException ex) {
			throw new BusinessException("Erro al crear la venta");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void actualizarVenta(VentasDTO ventaDTO) {
		VentaEntity ventaEntity = new VentaEntity();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			ventaEntity.setFolio(ventaDTO.getFolio());
			ventaEntity.setRFC(ventaDTO.getRFC());
			ventaEntity.setRazonSocial(ventaDTO.getRazonSocial());
			ventaEntity.setFecha(ventaDTO.getFecha());
			ventaEntity.setImporte(ventaDTO.getImporte());
			ventaEntity.setAlmacen(ventaDTO.getAlmacen());
			ventasQuery.actualizarVenta(ventaEntity);
			utx.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public VentasDTO obtenerVenta(Integer id) {
		VentasDTO ventaDTO = new VentasDTO();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			VentaEntity ventaEntity = ventasQuery.obtenerVenta(id);
			ventaDTO.setFolio(ventaEntity.getFolio());
			ventaDTO.setRFC(ventaEntity.getRFC());
			ventaDTO.setRazonSocial(ventaEntity.getRazonSocial());
			ventaDTO.setFecha(ventaEntity.getFecha());
			ventaDTO.setImporte(ventaEntity.getImporte());
			ventaDTO.setAlmacen(ventaEntity.getAlmacen());
			utx.commit();
			return ventaDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return ventaDTO;
	}

	public List<VentasDTO> listVentaDTO() {
		List<VentasDTO> listVentaDTO = new ArrayList<VentasDTO>();
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			List<VentaEntity> listaVentaEntities = ventasQuery.obtenerVentas();
			for (VentaEntity venta : listaVentaEntities) {
				VentasDTO ventaDTO = new VentasDTO();
				ventaDTO.setFolio(venta.getFolio());
				ventaDTO.setRFC(venta.getRFC());
				ventaDTO.setRazonSocial(venta.getRazonSocial());
				ventaDTO.setFecha(venta.getFecha());
				ventaDTO.setImporte(venta.getImporte());
				ventaDTO.setAlmacen(venta.getAlmacen());
				listVentaDTO.add(ventaDTO);
			}
			utx.commit();
			return listVentaDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return listVentaDTO;
	}

	public void borrarVenta(Integer id) {
		UserTransaction utx = context.getUserTransaction();
		try {
			utx.begin();
			ventasQuery.borrarVenta(id);
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
