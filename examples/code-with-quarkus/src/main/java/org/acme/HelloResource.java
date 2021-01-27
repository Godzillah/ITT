package org.acme;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class HelloResource {

    private List<String> greetingList = new ArrayList<>();
    private final String HELLO = "hello";

    public HelloResource() {
        this.greetingList.add(HELLO);
    }

    @GET
    public String list() {
        return this.greetingList.toString();
    }

    @POST
    public List<String> add() {
        this.greetingList.add(HELLO);
        return this.greetingList;
    }

    @DELETE
    public List<String> delete() {
        this.greetingList.remove(HELLO);
        return this.greetingList;
    }
}
