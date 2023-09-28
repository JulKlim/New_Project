package com.epam.tc.hw9.scenarios;

import static org.hamcrest.CoreMatchers.equalTo;

import com.epam.tc.hw9.testbase.TestBase;
import com.epam.tc.hw9.testdata.pet.Pet;
import com.epam.tc.hw9.testdata.pet.TestDataPet;
import org.testng.annotations.Test;

public class PetShopPetTests extends TestBase {
    @Test
    public void checkCreatePet() {
        requestSpec
            .body(TestDataPet.requestBodyPet())
            .when()
            .post("/pet")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test
    public void checkGetPetIsAvailable() {
        Pet pet = TestDataPet.getPetData();
        requestSpec
            .when()
            .get("/pet/" + pet.getId())
            .then()
            .assertThat()
            .statusCode(200)
            .body("status", equalTo("available"));
    }
}
