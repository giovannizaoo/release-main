package com.sicredi.steps.productsId;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class ProductsId {
    Response validarResponse;

    @org.junit.Test
    public void productsId() {

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/products/1");

        Assert.assertEquals("validar status code", 200, validarResponse.getStatusCode());

    }

    @org.junit.Test
    public void productsIdInvalido() {

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/products/0");

        Assert.assertEquals("validar status code", 404, validarResponse.getStatusCode());

    }
}
