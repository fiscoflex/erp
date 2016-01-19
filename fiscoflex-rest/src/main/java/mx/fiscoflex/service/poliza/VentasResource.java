package mx.fiscoflex.service.poliza;

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

import mx.fiscoflex.service.poliza.VentasDTO;
import mx.fiscoflex.service.poliza.VentasEJB;

@Path("/ventas")
public class VentasResource {

	@Inject
	VentasEJB ventasEJB;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crear(VentasDTO ventaDTO, @Context HttpServletRequest request) {
		ventasEJB.crear(ventaDTO);
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/numerodeventa/{id}")
	public Response obtener(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		VentasDTO ventaDTO = new VentasDTO();
		ventaDTO = ventasEJB.obtenerVenta(id);
		return Response.ok(ventaDTO).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{busqueda}")
	public Response obtenerLista(@PathParam("busqueda") String busqueda, @Context HttpServletRequest request) {
		List<VentasDTO> ventaDTO = new ArrayList<>();
		ventaDTO = ventasEJB.listVentaDTO();
		return Response.ok(ventaDTO).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response borrarRegistro(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		ventasEJB.borrarVenta(id);
		return Response.ok().build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarVenta(VentasDTO ventaDTO, @Context HttpServletRequest request) {
		ventasEJB.actualizarVenta(ventaDTO);
		return Response.ok().build();
	}
	
}
