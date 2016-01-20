package mx.fiscoflex.api.empresa;

import mx.fiscoflex.api.core.model.Empresa;
import mx.fiscoflex.api.empresa.EmpresaDTO;

public class EmpresaFactory {

	public static Empresa convert(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa();
		
		empresa.setIdEmpresa(empresaDTO.getIdEmpresa());
		empresa.setNombreRazonSocial(empresaDTO.getNombreRazonSocial());
		
		return empresa;
	}
}
