package mx.fiscoflex.rs.contabilidad.cuentacontable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mx.fiscoflex.rs.contabilidad.cuentacontable.CuentaContableDTO;
import mx.fiscoflex.rs.contabilidad.cuentacontable.CuentaContableService;

@Path("/cuentasContables")
public class CuentaContableResource {

	@Inject
	CuentaContableService cuentaContableService;

	/**
	 * Método para guardar/crear una cuenta contable
	 * 
	 * @param cuentaContableDTO
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crear(CuentaContableDTO cuentaContableDTO, @Context HttpServletRequest request) {
		cuentaContableService.crearCuentaContable(cuentaContableDTO);
		return Response.ok().build();
	}

	/**
	 * Método para obtener una cuenta contable
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/numeroCuenta/{id}")
	public Response obtenerCuentaContable(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		CuentaContableDTO cuentaContableDTO = new CuentaContableDTO();
		cuentaContableDTO = cuentaContableService.obtenerCuentaContable(id);
		return Response.ok(cuentaContableDTO).build();
	}

	/**
	 * Método que retorna la lista de las cuentas contables
	 * 
	 * @param busqueda
	 * @param request
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{busqueda}")
	public Response obtenerLista(@PathParam("busqueda") String busqueda, @Context HttpServletRequest request) {
		List<CuentaContableDTO> cuentasDTO = new ArrayList<>();
		cuentasDTO = cuentaContableService.listCuentaContable();
		return Response.ok(cuentasDTO).build();
	}

	/**
	 * Método para borrar una cuenta contable
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response borrarRegistro(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		cuentaContableService.borrarCuentaContable(id);
		return Response.ok().build();
	}

	/**
	 * Método para actualizar una cuenta contable
	 * 
	 * @param cuentaContableDTO
	 * @param request
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarCuentaContable(CuentaContableDTO cuentaContableDTO, @Context HttpServletRequest request) {
		cuentaContableService.actualizarCuentaContable(cuentaContableDTO);
		return Response.ok().build();
	}

}