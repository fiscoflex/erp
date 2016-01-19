package mx.fiscoflex.rs.core.usuario;

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

@Path("/usuarios")
public class UsuarioResource {

	@Inject
	UsuarioService usuarioService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(UsuarioDTO usuarioDTO, @Context HttpServletRequest request) {
		usuarioService.crearUsuario(usuarioDTO);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{nombre}")
	public Response obtenerUsuario(@PathParam("nombre") String nombre, @Context HttpServletRequest request) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO = usuarioService.obtenerUsuario(nombre);
		return Response.ok(usuarioDTO).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response borrarRegistro(@PathParam("id") Integer id, @Context HttpServletRequest request) {
		usuarioService.borrarUsuario(id);
		return Response.ok().build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarRegistro(UsuarioDTO usuarioDTO, @Context HttpServletRequest request) {
		usuarioService.actualizarUsuario(usuarioDTO);
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{busqueda}")
	public Response obtenerUsuarios(@PathParam("busqueda") String busqueda, @Context HttpServletRequest request) {
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		usuariosDTO = usuarioService.listaUsuarios();
		return Response.ok(usuariosDTO).build();
	}
}