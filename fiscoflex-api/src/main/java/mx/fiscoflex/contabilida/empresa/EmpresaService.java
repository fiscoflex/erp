package mx.fiscoflex.contabilida.empresa;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.codehaus.plexus.util.StringUtils;

import mx.fiscoflex.contabilidad.persistencia.EmpresaEntity;
import mx.fiscoflex.contabilidad.persistencia.EmpresaRepository;
import mx.fiscoflex.contabilidad.seguridad.autenticacion.ContextoSeguridad;
import mx.fiscoflex.contabilidad.seguridad.bitacora.Bitacora;
import mx.fiscoflex.contabilidad.seguridad.bitacora.BitacoraService;

@Stateless
public class EmpresaService {
	

	@Inject
	private EmpresaRepository empresaRepository;
	
	@Inject
	private BitacoraEmpresaFactory bitacoraEmpresaFactory;
	
	@Inject
	private BitacoraService bitacoraService;
	
	public void crearEmpresa(EmpresaDTO empresaDTO, ContextoSeguridad sesionDTO) {						
		
		// Verificar que se ha introducido el nombre de la empresa
		boolean nombreEsRequerido = StringUtils.isBlank(empresaDTO.getNombre());
		if(nombreEsRequerido) {
		//	errorService.error(ErrorEmpresa.NOMBRE_ES_REQUERIDO);
		}
		
		// Eliminar potenciales espacios en blanco a los lados
		String nombre = empresaDTO.getNombre().trim();
		
		// El largo no debe ser mayor a 500 caracteres
		boolean nombreEsMuyLargo = nombre.length() > 500;
		if(nombreEsMuyLargo) {
		//	errorService.error(ErrorEmpresa.NOMBRE_ES_MUY_LARGO);
		}
		
		
		// Bitacora del movimiento del usuario
		Bitacora bitacoraDTO = bitacoraEmpresaFactory.crear(empresaDTO, sesionDTO);
		bitacoraService.crearBitacora(bitacoraDTO);
		
		EmpresaEntity empresa = new EmpresaEntity();
		
		empresaRepository.guardar(empresa);
	}
}

