package com.epam.tc.hw9.scenarios;

import static org.hamcrest.CoreMatchers.equalTo;

import com.epam.tc.hw9.testbase.TestBase;
import com.epam.tc.hw9.testdata.user.TestDataUser;
import com.epam.tc.hw9.testdata.user.User;
import org.testng.annotations.Test;

public class PetShopUserTests extends TestBase {
    @Test
    public void checkCreateUser() {
        User user = TestDataUser.getUserData();
        String requestBody = TestDataUser.requestBodyUser(user);
        requestSpec
            .body(requestBody)
            .when()
            .post("/user")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test
    public void checkGetUser() {
        User user = TestDataUser.getUserData();

        requestSpec
            .when()
            .get("/user/" + user.getUsername())
            .then()
            .assertThat()
            .statusCode(200)
            .body("firstName", equalTo(user.getFirstName()))
            .body("lastName", equalTo(user.getLastName()));
    }

    @Test
    public void checkGetUserWhoDoesNotExist() {

        requestSpec
            .when()
            .get("/user/JohnSparrow")
            .then()
            .assertThat()
            .statusCode(404);
    }

    @Test
    public void checkUpdateUserPhoneNumber() {
        User user = TestDataUser.getUserDataNewPhone();
        String requestBody = TestDataUser.requestBodyUser(user);

        requestSpec
            .body(requestBody)
            .when()
            .put("/user/" + user.getUsername())
            .then()
            .assertThat()
            .statusCode(200);
    }
}
