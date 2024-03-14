package com.sicredi.steps.products;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class ProductsApiSteps {

    Response validarResponse;

    @org.junit.Test
    public void products() {

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/products");

        Assert.assertEquals("validar status code", 200, validarResponse.getStatusCode());

    }
}
