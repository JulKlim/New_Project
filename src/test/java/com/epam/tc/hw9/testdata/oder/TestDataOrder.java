package com.epam.tc.hw9.testdata.oder;

import com.epam.tc.hw9.testdata.pet.Pet;
import com.epam.tc.hw9.testdata.pet.TestDataPet;
import com.google.gson.JsonObject;

public class TestDataOrder {
    public static Order getOrderData() {
        Order order = new Order.OrderBuilder()
            .setId(2)
            .setQuantity(1)
            .setShipDate("2023-08-14T14:19:26.253Z")
            .setStatus("placed")
            .setComplete(true)
            .build();
        return order;
    }

    public static String requestBodyOrder() {
        Order order = getOrderData();
        Pet pet = TestDataPet.getPetData();
        JsonObject requestBody = new JsonObject();

        requestBody.addProperty("id", order.getId());
        requestBody.addProperty("petId", pet.getId());
        requestBody.addProperty("quantity", order.getQuantity());
        requestBody.addProperty("shipDate", order.getShipDate());
        requestBody.addProperty("status", order.getStatus());
        requestBody.addProperty("complete", order.isComplete());

        return requestBody.toString();
    }
}
