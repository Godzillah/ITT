package org.acme;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/conferences")
public class ConferenceResource {

    @Inject
    ConferenceService conferenceService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conference> getAll() {
        return conferenceService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Conference> create(Conference conference) {
        conference.create(conference);
    }

}
