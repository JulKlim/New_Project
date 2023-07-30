package com.epam.tc.hw6.runners;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw4.ex2.ScreenshotListener;
import com.epam.tc.hw6.common.DifferentElementsLog;
import com.epam.tc.hw6.common.DifferentElementsMainContent;
import com.epam.tc.hw6.common.HomePage;
import com.epam.tc.hw6.common.WebDriverSetUp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
@Severity(SeverityLevel.BLOCKER)
@Epic("Selenium UI exercises")
@Feature("Ex2")
@Story("Ex2: Log in and checking different elements page")
public class ExerciseTwo extends WebDriverSetUp {

    //1 Open test site by URL
    //2 Assert Browser title
    //3 Perform login
    //4 Assert Username is logged
    //5 Open through the header menu Service -> Different
    //Elements Page
    @Test(priority = 1)
    public void homePageActions() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        assertThat(homePage.checkTitle()).isEqualTo("Home Page");
        homePage.performLogin("Roman", "Jdi1234");
        assertThat(homePage.assertUsername()).isEqualTo("ROMAN IOVLEV");
        homePage.openDifferentElements();
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
        assertThat(differentElementsLog.isLogRowForWaterDisplayed())
                .as("Log row for Water checkbox is displayed").isTrue();
        assertThat(differentElementsLog.isLogRowForWindDisplayed())
                .as("Log row for Wind checkbox is displayed").isTrue();
    }

    //9.2 for radio button there is a log row and value
    //is corresponded to the status of radio button
    @Test(priority = 10)
    public void logRowRadio() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        assertThat(differentElementsLog.isLogRowRadioDisplayed())
                .as("Log row for radio button Selen is displayed").isTrue();
    }

    //9.3 for dropdown there is a log row and value is
    //corresponded to the selected value.
    @Test(priority = 11)
    public void logDropdown() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        assertThat(differentElementsLog.isLogDropdownDisplayed())
                .as("Log row for yellow color is displayed").isTrue();
    }

    //10 Closing browser
}
