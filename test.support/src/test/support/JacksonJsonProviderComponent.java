package test.support;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import test.support.api.JsonProvider;

import aQute.bnd.annotation.component.Component;

@Component
@Provider
@Consumes({MediaType.APPLICATION_JSON, "text/json"})
@Produces({MediaType.APPLICATION_JSON, "text/json"})
public class JacksonJsonProviderComponent extends
		org.codehaus.jackson.jaxrs.JacksonJsonProvider implements JsonProvider {
}