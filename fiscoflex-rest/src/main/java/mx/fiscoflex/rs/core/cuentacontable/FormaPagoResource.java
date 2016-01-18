package mx.fiscoflex.rs.core.cuentacontable;

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

import mx.fiscoflex.rs.core.cuentacontable.FormaPagoDTO;
import mx.fiscoflex.rs.core.cuentacontable.FormaPagoEJB;

@Path("/forma_pago")
public class FormaPagoResource {
	
	@Inject
	FormaPagoEJB formaPagoEJB;
	
	/**
	 * Guardar registro
	 * @param formaPagoDTO
	 * @param request
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Registrar(FormaPagoDTO formaPagoDTO, @Context HttpServletRequest request) {
		formaPagoEJB.crearRegistro(formaPagoDTO);
		return Response.ok().build();
	}

	/**
	 * Obtener un registro mediante Id
	 * @param id
	 * @param request
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/formaPago/{id}")
	public Response obtenerFormaPago(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		FormaPagoDTO formaPagoDTO= new FormaPagoDTO();
		formaPagoDTO = formaPagoEJB.obtenerFormaPago(id);
		return Response.ok(formaPagoDTO).build();
	}

	/**
	 * Obtener lista de todos los registros
	 * @param busqueda
	 * @param request
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{busqueda}")
	public Response listaFormaPago(@PathParam("busqueda") String busqueda, @Context HttpServletRequest request) {
		List<FormaPagoDTO> formaPagoDTO = new ArrayList<>();
		formaPagoDTO = formaPagoEJB.listCuentaContable();
		return Response.ok(formaPagoDTO).build();
	}

	/**
	 * Eliminar registro
	 * @param id
	 * @param request
	 * @return
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response borrarRegistro(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		formaPagoEJB.borrarRegistro(id);
		return Response.ok().build();
	}

	/**
	 * Editar registro
	 * @param formaPagoDTO
	 * @param request
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarRegistro(FormaPagoDTO formaPagoDTO, @Context HttpServletRequest request) {
		formaPagoEJB.actualizarRegistro(formaPagoDTO);
		return Response.ok().build();
	}
}
