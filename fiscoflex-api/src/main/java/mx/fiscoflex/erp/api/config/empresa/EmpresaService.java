package mx.fiscoflex.erp.api.config.empresa;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.codehaus.plexus.util.StringUtils;

import mx.fiscoflex.erp.api.bitacora.BitacoraDTO;
import mx.fiscoflex.erp.api.bitacora.BitacoraService;
import mx.fiscoflex.erp.api.error.ErrorService;
import mx.fiscoflex.erp.api.seguridad.sesion.SesionDTO;
import mx.fiscoflex.erp.persistence.model.Empresa;
import mx.fiscoflex.erp.persistence.repository.EmpresaRepository;

@Stateless
public class EmpresaService {
	
	@Inject
	private ErrorService errorService;

	@Inject
	private EmpresaRepository empresaRepository;
	
	@Inject
	private BitacoraEmpresaFactory bitacoraEmpresaFactory;
	
	@Inject
	private BitacoraService bitacoraService;
	
	public void crearEmpresa(EmpresaDTO empresaDTO, SesionDTO sesionDTO) {						
		
		// Verificar que se ha introducido el nombre de la empresa
		boolean nombreEsRequerido = StringUtils.isBlank(empresaDTO.getNombre());
		if(nombreEsRequerido) {
			errorService.error(ErrorEmpresa.NOMBRE_ES_REQUERIDO);
		}
		
		// Eliminar potenciales espacios en blanco a los lados
		String nombre = empresaDTO.getNombre().trim();
		
		// El largo no debe ser mayor a 500 caracteres
		boolean nombreEsMuyLargo = nombre.length() > 500;
		if(nombreEsMuyLargo) {
			errorService.error(ErrorEmpresa.NOMBRE_ES_MUY_LARGO);
		}
		
		
		// Bitacora del movimiento del usuario
		BitacoraDTO bitacoraDTO = bitacoraEmpresaFactory.crear(empresaDTO, sesionDTO);
		bitacoraService.crearBitacora(bitacoraDTO);
		
		Empresa empresa = new Empresa();
		
		empresaRepository.guardar(empresa);
	}
}

