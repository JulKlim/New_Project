package com.epam.tc.hw7.testdata;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataReader {

    public static List<TestDataEntry> readAllTestData() throws IOException {
        Gson gson = new Gson();
        List<TestDataEntry> testDataEntries = new ArrayList<>();
        try (FileReader fileReader = new FileReader("MetalsColorsDataSet.json")) {
            TestData testData = gson.fromJson(fileReader, TestData.class);
            testDataEntries.add(testData.getDataSet1());
            testDataEntries.add(testData.getDataSet2());
            testDataEntries.add(testData.getDataSet3());
            testDataEntries.add(testData.getDataSet4());
            testDataEntries.add(testData.getDataSet5());
        }
        return testDataEntries;
    }
}

