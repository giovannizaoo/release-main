package com.sicredi.model.authLogin;

import com.sicredi.model.authLogin.request.AuthLoginRequestModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetToken {
    public String getToken(String username, String senha) {
        {

            RestAssured.baseURI = "https://dummyjson.com";

            AuthLoginRequestModel sessaoDoUsuario = new AuthLoginRequestModel();
            sessaoDoUsuario.setUsername(username);
            sessaoDoUsuario.setPassword(senha);

            String token = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .header("Content-Type", "application/json")
                    .body(sessaoDoUsuario)
                    .post("/auth/login")
                    .then()
                    .extract()
                    .path("token");

            return token;

        }
    }
}
