package com.epam.tc.hw7.testdata;

import static com.epam.tc.hw7.testdata.TestDataReader.readAllTestData;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "testDataEntries")
    public static Object[][] testDataEntries() throws IOException {
        List<TestDataEntry> testDataEntries = readAllTestData();
        Object[][] testDataArray = new Object[testDataEntries.size()][1];
        for (int i = 0; i < testDataEntries.size(); i++) {
            testDataArray[i][0] = testDataEntries.get(i);
        }
        return testDataArray;
    }
}
