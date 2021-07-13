package org.acme.camel.infinispan.demo;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.ProducerTemplate;

@Path("/infinispan")
public class InfinispanResource {

    @Inject
    ProducerTemplate template;

    @PUT
    public void cachePut() {
        template.requestBody("direct:put", "Some cache value", String.class);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String cacheGet() {
        return template.requestBody("direct:get", null, String.class);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public void cacheRemove() {
        template.requestBody("direct:remove", null, String.class);
    }
}
