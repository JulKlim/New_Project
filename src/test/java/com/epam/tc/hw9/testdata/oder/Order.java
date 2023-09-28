package com.epam.tc.hw9.testdata.oder;

public class Order {
    private int id;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    private Order() {

    }

    public static class OrderBuilder {
        private final Order order = new Order();

        public Order.OrderBuilder setId(int id) {
            order.id = id;
            return this;
        }

        public Order.OrderBuilder setQuantity(int quantity) {
            order.quantity = quantity;
            return this;
        }

        public Order.OrderBuilder setShipDate(String shipDate) {
            order.shipDate = shipDate;
            return this;
        }

        public Order.OrderBuilder setStatus(String status) {
            order.status = status;
            return this;
        }

        public Order.OrderBuilder setComplete(boolean complete) {
            order.complete = complete;
            return this;
        }

        public Order build() {
            return order;
        }
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public String getStatus() {
        return status;
    }

    public boolean isComplete() {
        return complete;
    }
}
