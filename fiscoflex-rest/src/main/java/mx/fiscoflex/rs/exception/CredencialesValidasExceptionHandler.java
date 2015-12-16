package mx.fiscoflex.rs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CredencialesValidasExceptionHandler implements ExceptionMapper<CredencialesValidasException> {

	public Response toResponse(CredencialesValidasException exception) {
		return Response.status(Status.UNAUTHORIZED).entity(exception.getMessage()).build();
	}
}
