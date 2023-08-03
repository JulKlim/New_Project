package com.epam.tc.hw7.testscripts;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.HomePage;
import com.epam.tc.hw7.entities.JdiSite;
import com.epam.tc.hw7.entities.MetalsColorsPage;
import com.epam.tc.hw7.entities.MetalsColorsResults;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MetalsAndColorsTests {
    @BeforeClass
    public static void setUp() {
        PageFactory.initElements(JdiSite.class);
        WebDriverFactory.getDriver();
    }

    @Test (priority = 1)
    public void loginTest() {
        JdiSite jdiSite = new JdiSite();
        jdiSite.open();

        HomePage.loginIcon.click();
        HomePage.userField.input("Roman");
        HomePage.passwordField.input("Jdi1234");
        HomePage.loginButton.click();

        assertThat(HomePage.username.getText()).isEqualTo("ROMAN IOVLEV");
        HomePage.headerMenuMetalsAnsColors.click();
    }

    @Test (priority = 2)
    public void openMetalsColorsPageTest() {
        assertThat(MetalsColorsPage.getTitle().equals("Metal and Colors"));
    }

    @Test (priority = 3)
    public void selectRadioButtons() {
        MetalsColorsPage.selectOddNumber(5);
        MetalsColorsPage.selectEvenNumber(6);
        MetalsColorsPage.calculateButton.click();
    }

    @Test (priority = 4)
    public void selectElements() {
        String[] elements = {"Water", "Fire"};
        MetalsColorsPage.selectElements(elements);
    }

    @Test (priority = 5)
    public void selectColor() {
        MetalsColorsPage.selectColor("Green");
    }

    @Test (priority = 6)
    public void selectMetal() {
        MetalsColorsPage.selectMetal("Gold");
    }

    @Test (priority = 7)
    public void selectVegetables() {
        String[] vegetables = {"Tomato", "Vegetables"};
        MetalsColorsPage.selectVegetables(vegetables);
    }

    @Test (priority = 8)
    public void clickSubmitButton() {
        MetalsColorsPage.submitButton.click();
    }

    @Test (priority = 9)
    public void checkResultList() throws IOException {
        //MetalsColorsResults.getResultPanelValues();
        // Read the test data from the JSON file
        TestData testData = TestDataReader.readTestData("path/to/your/json/file.json");
        TestDataEntry testDataEntry = testData.getData_2(); // Replace "data_2" with the desired test data index

        String expectedText = String.format(
                "Summary: %d\nElements: %s\nColor: %s\nMetal: %s\nVegetables: %s",
                testDataEntry.getSummary().get(0),
                String.join(", ", testDataEntry.getElements()),
                testDataEntry.getColor(),
                testDataEntry.getMetals(),
                String.join(", ", testDataEntry.getVegetables())
        );

        assertThat(MetalsColorsResults.getResultPanelValues()).isEqualTo(expectedText);
    }


    //@AfterClass
    public static void tearDown() {
        WebDriverFactory.quit();
    }
}
