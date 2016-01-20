package mx.fiscoflex.api.empresa;

import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.fiscoflex.api.core.model.Empresa;
import mx.fiscoflex.api.core.repository.EmpresaRepository;
import mx.fiscoflex.api.empresa.EmpresaDTO;

@Stateless
public class EmpresaService {
	
	@Inject
	private EmpresaRepository empresaRepository;

	public void setEmpresaRepository(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public void crearEmpresa(EmpresaDTO empresaDTO) {
		
		// TODO: Falta definir en donde va los datos de la bitacora de quien intento guardar
		
		// TODO: Validar los parametros del alta de empresa
		
		Empresa empresa = EmpresaFactory.convert(empresaDTO);		
		empresaRepository.guardar(empresa);
	}
}
