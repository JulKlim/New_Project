package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;

public class MyCalculator {
    com.epam.tat.module4.Calculator calculator = new Calculator();

    public int sum(final int a, final int b) {

        return Math.addExact(a, b);
    }

    public int sub(final int a, final int b) {

        return Math.subtractExact(a, b);
    }

    public int mult(final int a, final int b) {

        return Math.multiplyExact(a, b);
    }

    public int div(final int a, final int b) {

        return Math.floorDiv(a, b);
    }
}
