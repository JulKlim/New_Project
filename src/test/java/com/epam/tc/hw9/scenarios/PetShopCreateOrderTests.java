package com.epam.tc.hw9.scenarios;

import static org.hamcrest.CoreMatchers.equalTo;

import com.epam.tc.hw9.testbase.TestBase;
import com.epam.tc.hw9.testdata.oder.Order;
import com.epam.tc.hw9.testdata.oder.TestDataOrder;
import org.testng.annotations.Test;

public class PetShopCreateOrderTests extends TestBase {
    @Test
    public void checkPlaceOrderWithPet() {
        requestSpec
            .body(TestDataOrder.getOrderData())
            .when()
            .post("store/order")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test(dependsOnMethods = "checkPlaceOrderWithPet")
    public void checkGetOrderWithPet() {
        Order order = TestDataOrder.getOrderData();
        requestSpec
            .get("store/order/" + order.getId())
            .then()
            .assertThat()
            .statusCode(200)
            .body("complete", equalTo(true))
            .body("quantity", equalTo(1));
    }
}
