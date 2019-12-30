package com.requestFilter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Provider
public class JaxRsFilterAuthentication implements ContainerRequestFilter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) {
		System.out.println("In the filter");

		String authCredentials = containerRequest.getHeaderValue(AUTHENTICATION_HEADER);
				
		System.out.println("In the filter==="+authCredentials);

		// better injected
		AuthenticationService authenticationService = new AuthenticationService();

		boolean authenticationStatus = authenticationService
				.authenticate(authCredentials);

		if (!authenticationStatus) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}

		return containerRequest;
	}
}
