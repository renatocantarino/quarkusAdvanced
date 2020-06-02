package com.cantarino.ifood.marketplace;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;


@QuarkusTest
public class PratoResourceTest {

    @Test
    public void TesteEndPoint()
    {
       String body = given()
        .when().get("/pratos")
        .then()
           .statusCode(200).extract().asString();

        System.out.println(body);
    }





}