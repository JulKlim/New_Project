package com.epam.tc.hw3.refactored.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.ex1.WebdriverSetUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class ExerciseTwo extends WebdriverSetUp {

    //1 Open test site by URL
    //2 Assert Browser title
    //3 Perform login
    //4 Assert Username is logged
    //5 Open through the header menu Service -> Different
    //Elements Page
    @Test(priority = 1)
    public void homePageActions() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage()
                .checkTitle("Home Page")
                .performLogin("Roman", "Jdi1234")
                .assertUsername("ROMAN IOVLEV")
                .openDifferentElements();
    }

    //6 Select checkboxes Water and Wind
    @Test(priority = 2)
    public void selectWaterAndWind() {
        DifferentElementsMainContent differentElementsMainContent = new DifferentElementsMainContent(driver);
        differentElementsMainContent.selectWater()
                        .selectWind();
    }

    //7 Select radio Selen
    //8 Select in dropdown Yellow
    @Test(priority = 3)
    public void selectRadioSelenAndDropdownYellow() {
        DifferentElementsMainContent differentElementsMainContent = new DifferentElementsMainContent(driver);
        differentElementsMainContent.selectRadioSelen()
                .selectDropdown()
                .selectYellow();
    }

    //9.1 Assert that for each checkbox there is an individual log
    //row and value is corresponded to the status
    //of checkbox
    @Test(priority = 9)
    public void logRowForCheckbox() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        boolean isLogRowWaterDisplayed = differentElementsLog
                .isLogRowForWaterDisplayed(
                "Water: condition changed to true");
        boolean isLogRowWindDisplayed = differentElementsLog
                .isLogRowForWindDisplayed("Wind: condition changed to true");

        assertThat(isLogRowWaterDisplayed).isTrue();
        assertThat(isLogRowWindDisplayed).isTrue();
    }

    //9.2 for radio button there is a log row and value
    //is corresponded to the status of radio button
    @Test(priority = 10)
    public void logRowRadio() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        boolean isLogRowSelenDisplayed = differentElementsLog
                .isLogRowRadioDisplayed("metal: value changed to  Selen");

        assertThat(isLogRowSelenDisplayed).isTrue();
    }

    //9.3 for dropdown there is a log row and value is
    //corresponded to the selected value.
    @Test(priority = 11)
    public void logDropdown() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        boolean isLogRowSelenDisplayed = differentElementsLog
                .isLogDropdownDisplayed("Colors: value changed to Yellow");

        assertThat(isLogRowSelenDisplayed).isTrue();
    }

    //10 Closing browser
    @AfterClass
    public void closing() {
        driver.quit();
    }
}
