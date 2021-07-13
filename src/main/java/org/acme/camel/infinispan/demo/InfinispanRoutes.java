package org.acme.camel.infinispan.demo;

import java.nio.charset.StandardCharsets;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.infinispan.InfinispanConstants;
import org.apache.camel.component.infinispan.InfinispanOperation;

public class InfinispanRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:put")
                .convertBodyTo(byte[].class)
                .setHeader(InfinispanConstants.OPERATION).constant(InfinispanOperation.PUT)
                .setHeader(InfinispanConstants.KEY).constant("the-key".getBytes(StandardCharsets.UTF_8))
                .setHeader(InfinispanConstants.VALUE).body()
                .to("infinispan:camel");

        from("direct:get")
                .setHeader(InfinispanConstants.OPERATION).constant(InfinispanOperation.GET)
                .setHeader(InfinispanConstants.KEY).constant("the-key".getBytes(StandardCharsets.UTF_8))
                .to("infinispan:camel");

        from("direct:remove")
                .setHeader(InfinispanConstants.OPERATION).constant(InfinispanOperation.REMOVE)
                .setHeader(InfinispanConstants.KEY).constant("the-key".getBytes(StandardCharsets.UTF_8))
                .to("infinispan:camel");
    }
}
