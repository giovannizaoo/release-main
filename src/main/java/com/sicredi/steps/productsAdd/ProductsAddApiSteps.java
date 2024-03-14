package com.sicredi.steps.productsAdd;

import com.sicredi.model.productsAdd.request.ProductsAddRequestModel;
import com.sicredi.model.productsAdd.response.ProductsAddResponseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ProductsAddApiSteps {

    ProductsAddResponseModel productsAddResponseModel;

    @org.junit.Test
    public void productsAdd() {

        RestAssured.baseURI = "https://dummyjson.com";

        ProductsAddRequestModel adicionarProdutos = new ProductsAddRequestModel();
        adicionarProdutos.setTitle("Perfume Oil");
        adicionarProdutos.setDescription("Mega Discount, Impression of A...");
        adicionarProdutos.setPrice(13);
        adicionarProdutos.setDiscountPercentage(8.4);
        adicionarProdutos.setStock(65);
        adicionarProdutos.setBrand("Impression of Acqua Di Gio");
        adicionarProdutos.setCategory("fragrances");
        adicionarProdutos.setThumbnail("https://i.dummyjson.com/data/products/11/thumnail.jpg");

        productsAddResponseModel = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .post("/products/add")
                .body()
                .as(ProductsAddResponseModel.class);

        System.out.print("Validar Status Code " + ProductsAddResponseModel.class);

        System.out.println("Validar campo com Json " + productsAddResponseModel);

    }
}
