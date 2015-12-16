package mx.fiscoflex.rs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AccesoDenegadoExceptionHandler implements ExceptionMapper<AccesoDenegadoException> {

	public Response toResponse(AccesoDenegadoException exception) {
		return Response.status(Status.FORBIDDEN).entity(exception.getMessage()).build();
	}
}
