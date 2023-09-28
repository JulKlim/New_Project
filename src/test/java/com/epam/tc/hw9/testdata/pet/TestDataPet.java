package com.epam.tc.hw9.testdata.pet;

import com.google.gson.JsonObject;

public class TestDataPet {

    public static Pet getPetData() {
        Pet pet = new Pet.PetBuilder()
            .setId(345)
            .setCategory("cat")
            .setName("Marty")
            .setStatus("available")
            .build();
        return pet;
    }

    public static String requestBodyPet() {
        Pet pet = getPetData();
        final JsonObject requestBody = new JsonObject();

        requestBody.addProperty("id", pet.getId());
        requestBody.addProperty("name", pet.getName());
        requestBody.addProperty("status", pet.getStatus());

        return requestBody.toString();
    }
}
