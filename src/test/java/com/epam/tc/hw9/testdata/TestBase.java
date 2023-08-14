package com.epam.tc.hw9.testdata;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public RequestSpecification requestSpec;

    @BeforeClass
    public void urlSetUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        requestSpec = given()
            .header("accept", "application/json")
            .header("Content-Type", "application/json");
    }

}
