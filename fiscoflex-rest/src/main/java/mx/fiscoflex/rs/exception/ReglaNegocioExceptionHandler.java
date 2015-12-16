package mx.fiscoflex.rs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ReglaNegocioExceptionHandler implements ExceptionMapper<ReglaNegocioException>{


	public Response toResponse(ReglaNegocioException exception) {
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}

}
