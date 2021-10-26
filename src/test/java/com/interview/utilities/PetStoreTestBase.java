package com.interview.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class PetStoreTestBase {

    @BeforeAll
    public static void init(){

        //save baseurl inside this variable so that we dont need to type each http method.

        baseURI = "https://petstore.swagger.io/v2";
    }

}
