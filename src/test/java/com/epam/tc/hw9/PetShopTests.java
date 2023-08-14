package com.epam.tc.hw9;

import static org.hamcrest.CoreMatchers.equalTo;

import com.epam.tc.hw9.testdata.Order;
import com.epam.tc.hw9.testdata.Pet;
import com.epam.tc.hw9.testdata.TestBase;
import com.epam.tc.hw9.testdata.TestData;
import com.epam.tc.hw9.testdata.User;
import org.testng.annotations.Test;

public class PetShopTests extends TestBase {
    @Test(priority = 1)
    public void checkCreateUser() {
        requestSpec
            .body(TestData.requestBodyUser())
            .when()
            .post("/user")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test(priority = 2)
    public void checkGetUser() {
        User user = TestData.getUserData();

        requestSpec
            .when()
            .get("/user/" + user.getUsername() + "")
            .then()
            .assertThat()
            .statusCode(200)
            .body("firstName", equalTo(user.getFirstName()))
            .body("lastName", equalTo(user.getLastName()));
    }

    @Test(priority = 3)
    public void checkGetUserWhoDoesNotExist() {

        requestSpec
            .when()
            .get("/user/JohnSparrow")
            .then()
            .assertThat()
            .statusCode(404);
    }

    @Test(priority = 4)
    public void checkUpdateUserPhoneNumber() {
        User user = TestData.getUserDataNewPhone();

        requestSpec
            .body(TestData.getUserDataNewPhone())
            .when()
            .put("/user/" + user.getUsername() + "")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test(priority = 5)
    public void checkCreatePet() {
        requestSpec
            .body(TestData.requestBodyPet())
            .when()
            .post("/pet")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test(priority = 6)
    public void checkGetPetIsAvailable() {
        Pet pet = TestData.getPetData();
        requestSpec
            .when()
            .get("/pet/" + pet.getId() + "")
            .then()
            .assertThat()
            .statusCode(200)
            .body("status", equalTo("available"));
    }

    @Test(priority = 7)
    public void checkPlaceOrderWithPet() {
        requestSpec
            .body(TestData.getOrderData())
            .when()
            .post("store/order")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test(priority = 8)
    public void checkGetOrderWithPet() {
        Order order = TestData.getOrderData();
        requestSpec
            .get("store/order/" + order.getId() + "")
            .then()
            .assertThat()
            .statusCode(200)
            .body("complete", equalTo(true))
            .body("quantity", equalTo(1));
    }

    @Test(priority = 9)
    public void checkDeleteOrderWithPet() {
        Order order = TestData.getOrderData();
        requestSpec
            .delete("store/order/" + order.getId())
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test(priority = 10)
    public void checkGetOrderWithPetThatDoesNotExist() {
        Order order = TestData.getOrderData();
        requestSpec
            .get("store/order/" + order.getId() + "")
            .then()
            .assertThat()
            .statusCode(404);
    }
}
