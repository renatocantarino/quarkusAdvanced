package com.cantarino.ifood.cadastro;

import javax.ws.rs.core.Response.Status;

import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.cantarino.ifood.cadastro.util.TokenUtils;


import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestauranteTest {

    private String token;
    @BeforeEach
    public void gereToken() throws Exception {
        token = TokenUtils.generateTokenString("/JWTProprietarioClaims.json", null);
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .contentType(ContentType.JSON).header(new Header("Authorization", "Bearer " + token));
    }



    @Test
    @DataSet("restaurantes-cenario-1.yml")
    public void testGetRestaurantes()
    {


        String resultado = given()
                            .when().get("/api/restaurantes")
                            .then()
                            .statusCode(Status.OK.getStatusCode())
                            .extract().asString();

        Approvals.verifyJson(resultado);

    }



}