package com.sicredi.steps.authProducts;

import com.sicredi.model.authLogin.GetToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class AuthProductsApiSteps {
    Response validarResponse;

    @org.junit.Test
    public void authProducts() {

        GetToken tokenValido = new GetToken();
        String token = tokenValido.getToken("kminchelle", "0lelplR");

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + tokenValido)
                .get("/auth/products");

        Assert.assertEquals("validar status code", 200, validarResponse.getStatusCode());


    }

    @org.junit.Test
    public void authProductsTokenInvalido() {

        GetToken tokenValido = new GetToken();
        String token = tokenValido.getToken("kminchelle", "0lelplR");

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " )
                .get("/auth/products");

        Assert.assertEquals("validar status code", 401, validarResponse.getStatusCode());


    }
    @org.junit.Test
    public void authProductsAuthProblem() {

        GetToken tokenValido = new GetToken();
        String token = tokenValido.getToken("kminchelle", "0lealplR");

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/auth/products");

        Assert.assertEquals("validar status code", 403, validarResponse.getStatusCode());


    }

}
