package id.kawahedukasi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "This is GET Method";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String post() {
        return "This is POST Method";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String put() {
        return "This is PUT Method";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete() {
        return "This is DELETE Method";
    }
}