package mx.fiscoflex.api.empresa;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mx.fiscoflex.api.empresa.EmpresaDTO;
import mx.fiscoflex.api.empresa.EmpresaService;

@Path("/empresas")
public class EmpresaResource {

	@Inject
	private EmpresaService empresaService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crear(EmpresaDTO empresaDTO) {
		
		// TODO: Como se maneja de este lado la seguridad y la bitacora de eventos
		// la bitacora de eventos se refiere al proceso de registrar las acciones de
		// usuarios registrados en el sistema con respecto a las llamadas realizadas a
		// los mismos para auditar las acciones que estos estan realizando en el sistema.
		
		// 
		
		
		 empresaService.crearEmpresa(empresaDTO);
		 return Response.ok().build();
	}
}
