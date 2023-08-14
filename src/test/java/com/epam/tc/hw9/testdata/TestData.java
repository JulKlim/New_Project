package com.epam.tc.hw9.testdata;

public class TestData {
    public static User getUserData() {
        User user = new User();
        user.setUsername("JohnS");
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setEmail("johns@gmail.com");
        user.setPassword("admin123");
        user.setPhone("777777777");
        return user;
    }

    public static String requestBodyUser() {
        User user = new User();
        String requestBody = String.format(
            "{\"username\":\"%s\","
                + "\"firstName\":\"%s\","
                + "\"lastName\":\"%s\","
                + "\"email\":\"%s\","
                + "\"password\":\"%s\","
                + "\"phone\":\"%s\"}",
            user.getUsername(), user.getFirstName(), user.getLastName(),
            user.getEmail(), user.getPassword(), user.getPhone());
        return requestBody;
    }

    public static User getUserDataNewPhone() {
        User user = new User();
        user.setUsername("JohnS");
        user.setFirstName("John");
        user.setLastName("Smith");
        user.setEmail("johns@gmail.com");
        user.setPassword("admin123");
        user.setPhone("8888888888");
        return user;
    }

    public static Pet getPetData() {
        Pet pet = new Pet();
        pet.setId(345);
        pet.setCategory("cat");
        pet.setName("Marty");
        pet.setPhotoUrls("string");
        pet.setTags(new String[] {"string"});
        pet.setStatus("available");
        return pet;
    }

    public static String requestBodyPet() {
        Pet pet = TestData.getPetData();
        String requestBody = String.format(
            "{\"id\": %d,"
                + "\"category\": {\"id\": %d,\"name\": \"%s\"},"
                + "\"name\": \"%s\","
                + "\"photoUrls\": [\"%s\"],"
                + "\"tags\": [{\"id\": %d,\"name\": \"%s\"}],"
                + "\"status\": \"%s\"}",
            pet.getId(), 1, pet.getCategory(),
            pet.getName(), pet.getPhotoUrls(), 0, pet.getTags()[0],
            pet.getStatus());
        return requestBody;
    }

    public static Order getOrderData() {
        Order order = new Order();
        order.setId(2);
        order.setQuantity(1);
        order.setShipDate("2023-08-14T14:19:26.253Z");
        order.setStatus("placed");
        order.setComplete(true);
        return order;
    }

    public static String requestBodyOrder() {
        Order order = TestData.getOrderData();
        Pet pet = TestData.getPetData();
        String requestBody = String.format(
            "{\"id\": %d,"
                + "\"petId\": %d,"
                + "\"quantity\": %d,"
                + "\"shipDate\": \"%s\","
                + "\"status\": \"%s\","
                + "\"complete\": %b}",
            order.getId(), pet.getId(), order.getQuantity(), order.getShipDate(), order.getStatus(),
            order.isComplete());
        return requestBody;
    }
}
