package com.interview.petStore;

import com.interview.pojo.Pet;
import com.interview.utilities.CreateRandomPet;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;


import static io.restassured.RestAssured.*;

import com.interview.utilities.PetStoreTestBase;

public class PetStore extends PetStoreTestBase {


    /*
        Given accept type is Json
        When user sends a Post request to "/pet" to create a new pet
        Then status code is 200
        And Content type is application/json
        And response Contains id of the created pet
        And user upload file to pet with the id in the response by send Post requests to "/pet/{petId}/uploadImage"
        And status code 200
        And Content type is application/json



     */

    @DisplayName("Create a new pet and add a picture to it")
    @Test
    public void test1(){

        Pet pet = CreateRandomPet.createRandomPet();

        Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).body(pet).log().all().post("/pet")
                .then().statusCode(200)
                .and().log().all().extract().response();

        Pet createdPet = response.as(Pet.class);

        Assertions.assertNotNull(createdPet.getId());

        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\download.jpg");

        given().multiPart("file", file, "multipart/form-data").log().all()
                .pathParam("petId", createdPet.getId()).post("/pet/{petId}/uploadImage")
                .then().statusCode(200)
                .and().log().all();

    }


    /*
        Given accept type is Json
        When user sends a Post request to "/pet" to create a new pet
        Then status code is 200
        And Content type is application/json
        And response Contains id of the created pet
        And user sends get request to "/pet/{petId}" with the created pet's id as path parameter
        And status code 200
        And Content type is application/json
        And user sends get request to "/pet/findByStatus" with the status of the created pet as query parameter
        And status code is 200
        And Content type is application/json


     */



    @DisplayName("Search for new pet and similar pets")
    @Test
    public void test2(){

        Pet pet = CreateRandomPet.createRandomPet();

        Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).body(pet).log().all().post("/pet")
                .then().statusCode(200)
                .and().log().all().extract().response();

        Pet newPet = response.as(Pet.class);

        Assertions.assertNotNull(newPet.getId());

        given().accept(ContentType.JSON).log().all().pathParam("petId", newPet.getId()).get("/pet/{petId}")
                .then().statusCode(200)
                .and().contentType(ContentType.JSON).log().all();

        given().accept(ContentType.JSON).log().all().queryParam("status", newPet.getStatus()).get("/pet/findByStatus")
                .then().statusCode(200)
                .and().contentType(ContentType.JSON).log().all();

    }

}
