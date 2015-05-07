package net.slintes.osgi.helloworldrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorld {

	@GET @Path("world")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld(){
		return "Hello World from OSGi REST";
	}
	
}
