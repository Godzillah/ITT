package org.acme;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
@RegisterRestClient
@Retry(maxRetries = 3, delay = 2)
@CircuitBreaker(successThreshold = 1)
public interface CountryClient {

    @GET
    @Path("/conferences/{name}/country")
    Country getCountry(@PathParam("name") String name);
}
