package mx.fiscoflex.contabilidad.seguridad.autenticacion;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.spi.ResteasyProviderFactory;

@Provider
public class SesionProvider implements ContainerRequestFilter {
	
	@Context HttpServletRequest httpServletRequest;

	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
     //   String userId = containerRequestContext.getHeaders().getFirst("token");
       
        /*
        if (StringUtils.isEmpty(userId)) {
            Response response = Response
                    .status(Response.Status.BAD_REQUEST)
                    .type(MediaType.TEXT_PLAIN_TYPE)
                    .entity("User-Id header is missing.")
                    .build();
            containerRequestContext.abortWith(response);
            return;
        }
        */

        //do your logic to obtain the User object by userId

		 String ip = httpServletRequest.getRemoteHost();
		
      /*  UsuarioDTO usuarioOrigenDTO = new UsuarioDTO();
        usuarioOrigenDTO.setNombreUsuario("enrique");
        usuarioOrigenDTO.setIp(ip);
        ResteasyProviderFactory.pushContext(UsuarioDTO.class, usuarioOrigenDTO);
        
        */
    }
}
