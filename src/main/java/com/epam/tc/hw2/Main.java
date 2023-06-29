package com.epam.tc.hw2;

import com.epam.tat.module4.Calculator;

public class Main {
    public static void main(String[] args) {
        com.epam.tat.module4.Calculator calculator = new Calculator();
        long sumValue = calculator.sum(5, 10);
        long divValue = calculator.div(25, 5);
        long subValue = calculator.sub(10, 5);
        long multValue = calculator.mult(5, 10);
        System.out.println(sumValue + " " + divValue + " " + subValue + " " + multValue);
    }
}
