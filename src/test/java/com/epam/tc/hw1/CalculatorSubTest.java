package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class CalculatorSubTest extends CalculatorInit {

    @Test(dataProvider = "testDataForSub", dataProviderClass = CalculatorTestData.class)
    public void testSubOperations(final int a, final int b, final int expected) {
        long actualValue = calculator.sub(a, b);
        assertThat(actualValue)
                .as("Wrong calculation of subtraction")
                .isEqualTo(expected);
    }
}
