package mx.fiscoflex.api.core.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class ErrorInesperadoExceptionHandler implements ExceptionMapper<ErrorInesperadoException>{

	public Response toResponse(ErrorInesperadoException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
	}

}
