package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class CalculatorTestData {
    @DataProvider(name = "testDataForSum")
    public static Object[][] getTestDataForSum() {
        return new Object[][]{
                {0, 0, 0},
                {10, 20, 30},
                {-10, 11, 1}
        };
    }

    @DataProvider(name = "testDataForSub")
    public static Object[][] getTestDataForSub() {
        return new Object[][]{
                {10, 10, 0},
                {10, 20, -10},
                {-100, 10, -110}
        };
    }

    @DataProvider(name = "testDataForMulti")
    public static Object[][] getTestDataForMulti() {
        return new Object[][]{
                {10, 10, 100},
                {5, 4, 20},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "testDataForDivision")
    public static Object[][] getTestDataForDivision() {
        return new Object[][]{
                {100, 10, 10},
                {-20, -5, 4},
                {9, 3, 3}
        };
    }
}
