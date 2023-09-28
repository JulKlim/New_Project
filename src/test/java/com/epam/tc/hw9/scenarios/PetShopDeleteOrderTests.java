package com.epam.tc.hw9.scenarios;

import com.epam.tc.hw9.testbase.TestBase;
import com.epam.tc.hw9.testdata.oder.Order;
import com.epam.tc.hw9.testdata.oder.TestDataOrder;
import org.testng.annotations.Test;

public class PetShopDeleteOrderTests extends TestBase {
    @Test
    public void checkDeleteOrderWithPet() {
        Order order = TestDataOrder.getOrderData();
        requestSpec
            .delete("store/order/" + order.getId())
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test(dependsOnMethods = "checkDeleteOrderWithPet")
    public void checkGetOrderWithPetThatDoesNotExist() {
        Order order = TestDataOrder.getOrderData();
        requestSpec
            .get("store/order/" + order.getId())
            .then()
            .assertThat()
            .statusCode(404);
    }
}
