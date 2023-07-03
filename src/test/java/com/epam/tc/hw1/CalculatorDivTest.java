package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class CalculatorDivTest extends CalculatorInit {
    @Test(dataProvider = "testDataForDivision", dataProviderClass = CalculatorTestData.class)
    public void testDivOperations(final int a, final int b, final int expected) {
        long actualValue = calculator.div(a, b);
        assertThat(actualValue)
                .as("Wrong division of numbers")
                .isEqualTo(expected);
    }
}
