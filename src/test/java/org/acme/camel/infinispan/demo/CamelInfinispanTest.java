package org.acme.camel.infinispan.demo;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class CamelInfinispanTest {

    @Test
    public void testCamelInfinispan() {
        // Cache put
        RestAssured.with()
                .put("/infinispan")
                .then()
                .statusCode(204);

        // Cache get
        RestAssured.with()
                .get("/infinispan")
                .then()
                .statusCode(200)
                .body(equalTo("Some cache value"));

        // Cache remove
        RestAssured.with()
                .delete("/infinispan")
                .then()
                .statusCode(204);

        // Confirm remove
        RestAssured.with()
                .get("/infinispan")
                .then()
                .statusCode(204);
    }
}
