package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class CalculatorInit {
    public com.epam.tat.module4.Calculator calculator;

    @BeforeClass
    public void initializeSystemUnderTest() {

        calculator = new Calculator();
    }
}
