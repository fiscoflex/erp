package mx.fiscoflex.rs.service.venta;

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

import mx.fiscoflex.rs.service.venta.ConceptoDTO;
import mx.fiscoflex.rs.service.venta.ConceptoEJB;

@Path("/conceptos")
public class ConceptoResource {

	@Inject
	ConceptoEJB conceptoEJB;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearConcepto(ConceptoDTO conceptoDTO, @Context HttpServletRequest request) {
		conceptoEJB.crearConcepto(conceptoDTO);
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response obtenerConcepto(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		ConceptoDTO conceptoDTO = new ConceptoDTO();
		conceptoDTO = conceptoEJB.obtenerConcepto(id);
		return Response.ok(conceptoDTO).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{busqueda}")
	public Response obtenerListaConceptos(@PathParam("busqueda") String busqueda, @Context HttpServletRequest request) {
		List<ConceptoDTO> listaConceptoDTO = new ArrayList<ConceptoDTO>();
		listaConceptoDTO = conceptoEJB.listaConcepto();
		return Response.ok(listaConceptoDTO).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response borrarConcepto(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		conceptoEJB.borrarConcepto(id);
		return Response.ok().build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarConcepto(ConceptoDTO conceptoDTO, @Context HttpServletRequest request) {
		conceptoEJB.actualizarConcepto(conceptoDTO);
		return Response.ok().build();
	}

}
