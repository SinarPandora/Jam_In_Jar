package o.lartifa.jij

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

@Path("/hello-resteasy")
class GreetingResource {

    @GET
    @Produces(Array[String](MediaType.APPLICATION_JSON))
    def hello(): Map[String, String] = Map("hello" -> "world")
}
