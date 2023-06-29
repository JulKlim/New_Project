package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CalculatorMultiTest {
    private com.epam.tat.module4.Calculator calculator;

    @BeforeTest
    private void initializeSystemUnderTest() {

        calculator = new Calculator();
    }

    @Test(dataProvider = "testDataForMulti", dataProviderClass = CalculatorTestData.class)
    public void testSumOperations(final int a, final int b, final int expected) {
        long actualValue = calculator.mult(a, b);
        assertThat(actualValue)
                .as("Wrong multiplication of numbers")
                .isEqualTo(expected);
    }
}
