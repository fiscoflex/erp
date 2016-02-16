
package mx.fiscoflex.contabilidad.empresa;

import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.fiscoflex.contabilidad.bd.contabilidad.EmpresaEntity;
import mx.fiscoflex.contabilidad.bd.contabilidad.EmpresaQuery;
import mx.fiscoflex.contabilidad.seguridad.autenticacion.ContextoSeguridad;
import mx.fiscoflex.contabilidad.seguridad.autorizacion.AutorizacionService;
import mx.fiscoflex.contabilidad.seguridad.bitacora.BitacoraService;



@Stateless
public class EmpresaService {

	@Inject
	private EmpresaQuery empresaQuery;
	
	@Inject
	private AutorizacionService autorizacionService;
	
	@Inject
	private BitacoraService bitacoraService;

	public void crearEmpresa(Empresa empresa,
			ContextoSeguridad contextoSeguridad) {

		
		
		autorizacionService.autorizado("CREAR EMPRESA", contextoSeguridad.getNombreUsuario());
		
		// Validar que no se permitan empresas con el rfc duplicado
		EmpresaEntity empresaConta = null;// empresaQuery.empresaPorRfc(empresaDTO.getRfc());
	}
}
