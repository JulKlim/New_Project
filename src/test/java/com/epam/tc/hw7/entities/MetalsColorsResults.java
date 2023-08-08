package com.epam.tc.hw7.entities;

import static java.lang.Integer.sum;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.testdata.TestDataEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MetalsColorsResults extends WebPage {

    @FindBy(css = ".summ-res")
    public static Text summary;
    @FindBy(css = ".elem-res")
    public static Text elements;
    @FindBy(css = ".col-res")
    public static Text colors;
    @FindBy(css = ".met-res")
    public static Text metals;
    @FindBy(css = ".sal-res")
    public static Text salad;

    public static List<String> getResultPanelValues() {
        List<String> resultValues = new ArrayList<>();
        resultValues.add(summary.getValue());
        resultValues.add(elements.getText());
        resultValues.add(colors.getText());
        resultValues.add(metals.getText());
        resultValues.add(salad.getText());

        return resultValues;
    }

    public static int summarySum(TestDataEntry testDataEntry) {
        int oddNumber = testDataEntry.getSummary().get(0);
        int evenNumber = testDataEntry.getSummary().get(1);
        return sum(oddNumber, evenNumber);
    }

    public static String[] getExpectedPanelValues(TestDataEntry testDataEntry) throws IOException {

        String[] expectedResult = {
                String.format("Summary: %d", MetalsColorsResults.summarySum(testDataEntry)),
                String.format("Elements: %s", String.join(", ", testDataEntry.getElements())),
                String.format("Color: %s", testDataEntry.getColor()),
                String.format("Metal: %s", testDataEntry.getMetals()),
                String.format("Vegetables: %s", String.join(", ", testDataEntry.getVegetables()))
        };
        return expectedResult;
    }
}
