package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class CalculatorSumTest extends CalculatorInit {
    @Test(dataProvider = "testDataForSum", dataProviderClass = CalculatorTestData.class)
    public void testSumOperations(final int a, final int b, final int expected) {
        long actualValue = calculator.sum(a, b);
        assertThat(actualValue)
                .as("Wrong calculation of sum")
                .isEqualTo(expected);
    }
}
