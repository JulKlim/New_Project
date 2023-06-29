package com.epam.tc.hw1;

public class Main {
    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();
        int actualValue = calc.sum(5, 10);
        System.out.println(actualValue);
    }
}
