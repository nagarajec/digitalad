package org.javaworks.digitalad.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<AdCampaignException> {

	@Override
	public Response toResponse(AdCampaignException ex) {
		return Response.status(ex.getStatus())
				.entity(ex.getMessage())
				.type(MediaType.APPLICATION_JSON).
				build();
	}

	
	
}