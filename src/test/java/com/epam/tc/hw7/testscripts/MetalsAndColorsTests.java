package com.epam.tc.hw7.testscripts;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.HomePage;
import com.epam.tc.hw7.entities.JdiSite;
import com.epam.tc.hw7.entities.MetalsColorsPage;
import com.epam.tc.hw7.entities.MetalsColorsResults;
import com.epam.tc.hw7.testdata.TestDataEntry;
import com.epam.tc.hw7.testdata.TestDataProvider;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MetalsAndColorsTests {

    @BeforeClass
    public static void setUp() {
        PageFactory.initElements(JdiSite.class);
        WebDriverFactory.getDriver();
    }

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void openMetalsColorsPageTest() {
        assertThat(MetalsColorsPage.getTitle().equals("Metal and Colors"));
    }

    @Test(priority = 3, dataProvider = "testDataEntries", dataProviderClass = TestDataProvider.class)
    public void fillInAndSubmitForm(TestDataEntry testDataEntry) throws IOException {
        int oddNumber = testDataEntry.getSummary().get(0);
        int evenNumber = testDataEntry.getSummary().get(1);
        MetalsColorsPage.selectOddNumber(oddNumber);
        MetalsColorsPage.selectEvenNumber(evenNumber);
        MetalsColorsPage.calculateButton.click();
        List<String> elements = testDataEntry.getElements();
        MetalsColorsPage.selectElements(elements);
        MetalsColorsPage.selectColor(testDataEntry.getColor());
        MetalsColorsPage.selectMetal(testDataEntry.getMetals());
        MetalsColorsPage.selectVegetables(testDataEntry.getVegetables());
        MetalsColorsPage.submitButton.click();

        String[] expectedResult = MetalsColorsResults.getExpectedPanelValues(testDataEntry);
        assertThat(MetalsColorsResults.getResultPanelValues()
                .toArray(new String[0])).isEqualTo(expectedResult);
        MetalsColorsPage.refresh();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverFactory.quit();
    }
}
