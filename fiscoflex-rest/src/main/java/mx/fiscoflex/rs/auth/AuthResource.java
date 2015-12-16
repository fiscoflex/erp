package mx.fiscoflex.rs.auth;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mx.fiscoflex.api.CredencialesInvalidasException;


@Path("/auth")
public class AuthResource {

	@Inject
	private AuthService authService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String login(LoginDTO loginDTO) throws CredencialesInvalidasException{
		return authService.login(loginDTO);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cerrarSesion(String token) {
		authService.cerrarSesion(token);
		return Response.ok().build();
	}
}