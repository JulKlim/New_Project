package com.epam.tc.hw9.testdata.user;

import com.google.gson.JsonObject;

public class TestDataUser {
    public static User getBaseUserData(String phoneNumber) {
        User user = new User.UserBuilder()
            .setUsername("JohnS")
            .setFirstName("John")
            .setLastName("Smith")
            .setEmail("johns@gmail.com")
            .setPassword("admin123")
            .setPhone(phoneNumber)
            .build();
        return user;
    }

    public static User getUserData() {
        return getBaseUserData("777777777");
    }

    public static String requestBodyUser(User user) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("username", user.getUsername());
        requestBody.addProperty("firstName", user.getFirstName());
        requestBody.addProperty("lastName", user.getLastName());
        requestBody.addProperty("email", user.getEmail());
        requestBody.addProperty("password", user.getPassword());
        requestBody.addProperty("phone", user.getPhone());
        return requestBody.toString();
    }

    public static User getUserDataNewPhone() {
        return getBaseUserData("8888888888");
    }
}

