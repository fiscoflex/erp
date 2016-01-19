package mx.fiscoflex.rs.service.cuentacontable;

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

import mx.fiscoflex.rs.exception.BusinessException;
import mx.fiscoflex.rs.model.FormaPago;
import mx.fiscoflex.rs.repository.FormaPagoQuery;
import mx.fiscoflex.rs.service.cuentacontable.FormaPagoDTO;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class FormaPagoEJB {
	@Inject
	FormaPagoQuery formaPagoQuery;

	@Resource
	EJBContext context;

	/**
	 * Método para crear registro
	 * 
	 * @param formaPagoDTO
	 */
	public void crearRegistro(FormaPagoDTO formaPagoDTO) {
		FormaPago formaPagoEntity = new FormaPago();
		UserTransaction userTransaction = context.getUserTransaction();
		try {
			userTransaction.begin();
			formaPagoEntity.setTipoPago(formaPagoDTO.getTipoPago());
			formaPagoEntity.setImporte(formaPagoDTO.getImporte());
			formaPagoEntity.setBanco(formaPagoDTO.getBanco());
			formaPagoEntity.setCuenta(formaPagoDTO.getCuenta());
			formaPagoEntity.setReferencia(formaPagoDTO.getReferencia());
			formaPagoQuery.guardar(formaPagoEntity);
			userTransaction.commit();
		} catch (PersistenceException exp) {

			throw new BusinessException("Se genero un error al guardar información");
		} catch (Exception exp) {
			try {
				userTransaction.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			exp.printStackTrace();
		}
	}

	/**
	 * Método para obtener datos de un registro mediante un id
	 * @param id
	 * @return
	 */
	public FormaPagoDTO obtenerFormaPago(Integer id) {
		FormaPagoDTO formaPagoDTO = new FormaPagoDTO();
		UserTransaction userTransaction = context.getUserTransaction();
		try {
			userTransaction.begin();
			FormaPago formaPagoEntity = formaPagoQuery.obtenerFormaPagoId(id);
			formaPagoDTO.setTipoPago(formaPagoEntity.getTipoPago());
			formaPagoDTO.setImporte(formaPagoEntity.getImporte());
			formaPagoDTO.setBanco(formaPagoEntity.getBanco());
			formaPagoDTO.setCuenta(formaPagoEntity.getCuenta());
			formaPagoDTO.setReferencia(formaPagoEntity.getReferencia());
			userTransaction.commit();
			return formaPagoDTO;
		} catch (NoResultException ex) {
			throw new BusinessException("No se encontraron resultados.");
		} catch (Exception ex) {
			try {
				userTransaction.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return formaPagoDTO;
	}
	
/**
 * Método que nos permite editar un registro
 * @param formaPagoDTO
 */
	public void actualizarRegistro(FormaPagoDTO formaPagoDTO)
	{
		FormaPago formaPagoEntity= new FormaPago();
		UserTransaction userTransaction = context.getUserTransaction();
		try{
			userTransaction.begin();
			formaPagoEntity.setIdPago(formaPagoDTO.getIdPago());
			formaPagoEntity.setTipoPago(formaPagoDTO.getTipoPago());
			formaPagoEntity.setImporte(formaPagoDTO.getImporte());
			formaPagoEntity.setBanco(formaPagoDTO.getBanco());
			formaPagoEntity.setCuenta(formaPagoDTO.getCuenta());
			formaPagoEntity.setReferencia(formaPagoDTO.getReferencia());
			
			formaPagoQuery.guardar(formaPagoEntity);
			userTransaction.commit();
			
		}
		catch(PersistenceException ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	/**
	 * Método que nos permite eliminar un registro
	 * @param id
	 */
	public void borrarRegistro(Integer id){
		UserTransaction utx = context.getUserTransaction();
		try{
			utx.begin();
			formaPagoQuery.eliminar(id);
			utx.commit();
		}catch(NoResultException ex){
				throw new BusinessException("No exite el registro");
		}catch(Exception ex){
			try{
				utx.rollback();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
	}
	
	public List<FormaPagoDTO> listCuentaContable() {
		List<FormaPagoDTO> list = new ArrayList<FormaPagoDTO>();

		UserTransaction userTransaction = context.getUserTransaction();

		try {
			userTransaction.begin();
			List<FormaPago> listaFormaPago = formaPagoQuery.allFormasPago();
			for (FormaPago formaPagoEntity : listaFormaPago) {
				FormaPagoDTO formaPagoDTO = new FormaPagoDTO();
				formaPagoDTO.setTipoPago(formaPagoEntity.getTipoPago());
				formaPagoDTO.setImporte(formaPagoEntity.getImporte());
				formaPagoDTO.setBanco(formaPagoEntity.getBanco());
				formaPagoDTO.setCuenta(formaPagoEntity.getCuenta());
				formaPagoDTO.setReferencia(formaPagoEntity.getReferencia());
				list.add(formaPagoDTO);
			}
			userTransaction.commit();
			return list;
		} catch (NoResultException ex) {
			throw new BusinessException("No hay registros que mostrar.");
		} catch (Exception ex) {
			try {
				userTransaction.rollback();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
}
