package com.sicredi.steps.users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class UsersApiSteps {
    Response validarResponse;

    @org.junit.Test
    public void users() {

        RestAssured.baseURI = "https://dummyjson.com";

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/users");

        Assert.assertEquals("validar status code", 200, validarResponse.getStatusCode());

        System.out.println("Validar campo com Json " + validarResponse.asPrettyString());

    }
}
