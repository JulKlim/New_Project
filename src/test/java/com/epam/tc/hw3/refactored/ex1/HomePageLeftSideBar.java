package com.epam.tc.hw3.refactored.ex1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class HomePageLeftSideBar {
    final WebDriver driver;
    final WebDriverWait wait;
    final SoftAssert softAssert;
    final WebElement sidebar;
    final List<WebElement> sectionsOnTheLeft;


    public HomePageLeftSideBar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.softAssert = new SoftAssert();
        this.sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.sidebar-menu.left")));
        this.sectionsOnTheLeft = sidebar.findElements(
                By.xpath(".//li[@index >= '1' and @index <= '5' and not(ancestor::li)]"));
    }

    public void isItemsLeftSideBarCountCorrect(int expectedNumberOfSections) {
        int actualNumberOfSections = sectionsOnTheLeft.size();
        softAssert.assertEquals(actualNumberOfSections, expectedNumberOfSections);
        softAssert.assertAll();
    }

    public void areItemsLeftSideBarDisplayed() {
        boolean ifItemsLeftBarDisplayed = true;
        for (WebElement section : sectionsOnTheLeft) {
            boolean isSectionDisplayed = section.isDisplayed();
            if (!isSectionDisplayed) {
                ifItemsLeftBarDisplayed = false;
            }
        }
        softAssert.assertTrue(ifItemsLeftBarDisplayed);
        softAssert.assertAll();
    }

    public void ifSectionNamesMatch(String[] expectedSections) {
        boolean ifSectionNamesMatch = true;
        for (int j = 0; j < sectionsOnTheLeft.size(); j++) {
            String actualSectionText = sectionsOnTheLeft.get(j).getText();
            if (!actualSectionText.equals(expectedSections[j])) {
                ifSectionNamesMatch = false;
            }
        }
        softAssert.assertTrue(ifSectionNamesMatch);
        softAssert.assertAll();
    }
}
