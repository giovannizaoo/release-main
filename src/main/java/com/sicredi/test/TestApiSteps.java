package com.sicredi.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class TestApiSteps {

    Response validarResponse;

    @org.junit.Test
    public void test() {

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/test");
        Assert.assertEquals("validar status code", 200, validarResponse.getStatusCode());

    }
}