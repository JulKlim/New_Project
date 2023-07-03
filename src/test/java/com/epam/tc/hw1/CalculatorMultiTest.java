package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class CalculatorMultiTest extends CalculatorInit {

    @Test(dataProvider = "testDataForMulti", dataProviderClass = CalculatorTestData.class)
    public void testMultiOperations(final int a, final int b, final int expected) {
        long actualValue = calculator.mult(a, b);
        assertThat(actualValue)
                .as("Wrong multiplication of numbers")
                .isEqualTo(expected);
    }
}
