package com.epam.tc.hw4.ex1;

import io.qameta.allure.Step;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageLeftSideBar {
    final WebDriver driver;
    final WebDriverWait wait;


    public HomePageLeftSideBar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Checking count of items in left side bar")
    public boolean isItemsLeftSideBarCountCorrect(int expectedNumberOfSections) {
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.sidebar-menu.left")));
        List<WebElement> sectionsOnTheLeft = sidebar.findElements(
                By.xpath(".//li[@index >= '1' and @index <= '5' and not(ancestor::li)]"));

        return sectionsOnTheLeft.size() == expectedNumberOfSections;
    }

    @Step("Checking items in left side bar are displayed")
    public boolean areItemsLeftSideBarDisplayed() {
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.sidebar-menu.left")));
        List<WebElement> sectionsOnTheLeft = sidebar.findElements(
                By.xpath(".//li[@index >= '1' and @index <= '5' and not(ancestor::li)]"));

        boolean ifItemsLeftBarDisplayed = true;
        for (WebElement section : sectionsOnTheLeft) {
            boolean isSectionDisplayed = section.isDisplayed();
            if (!isSectionDisplayed) {
                ifItemsLeftBarDisplayed = false;
            }
        }
        return ifItemsLeftBarDisplayed;
    }

    @Step("Checking names of sections from left side bar are correct")
    public boolean ifSectionNamesMatch(String[] expectedSections) {
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.sidebar-menu.left")));
        List<WebElement> sectionsOnTheLeft = sidebar.findElements(
                By.xpath(".//li[@index >= '1' and @index <= '5' and not(ancestor::li)]"));

        boolean ifSectionNamesMatch = true;
        for (int j = 0; j < sectionsOnTheLeft.size(); j++) {
            String actualSectionText = sectionsOnTheLeft.get(j).getText();
            if (!actualSectionText.equals(expectedSections[j])) {
                ifSectionNamesMatch = false;
            }
        }
        return ifSectionNamesMatch;
    }
}
