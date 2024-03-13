package com.sicredi.steps.authLogin;

import com.sicredi.model.authLogin.request.AuthLoginRequestModel;
import com.sicredi.model.authLogin.response.AuthLoginResponseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AuthLoginApiSteps {

    AuthLoginResponseModel authLoginResponseModel;

    @org.junit.Test
    public void authLogin() {

        RestAssured.baseURI = "https://dummyjson.com";

        AuthLoginRequestModel sessaoDoUsuario = new AuthLoginRequestModel();
        sessaoDoUsuario.setUsername("kminchelle");
        sessaoDoUsuario.setPassword("0lelplR");

        authLoginResponseModel = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(sessaoDoUsuario)
                .post("/auth/login")
                .body()
                .as(AuthLoginResponseModel.class);

    }
}
