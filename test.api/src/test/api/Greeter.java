package test.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public interface Greeter {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	GreetingMessage greeting();
}
