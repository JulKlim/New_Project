package com.epam.tc.hw3.ex1;

import io.qameta.allure.Step;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageHeader {
    final WebDriver driver;
    final WebDriverWait wait;

    public HomePageHeader(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Checking number of header items")
    public boolean isItemsCountCorrect(int expectedNumberOfButtons) {
        List<WebElement> headerButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8:first-of-type>li>a")));
        return (headerButtons.size() == (expectedNumberOfButtons));
    }

    @Step("Checking names of header items")
    public boolean isItemsNamesCorrect(String[] expectedHeaderButtonsTexts) {
        List<WebElement> headerButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8:first-of-type>li>a")));

        boolean allNamesMatch = true;
        for (int n = 0; n < headerButtons.size(); n++) {
            String actualHeaderText = headerButtons.get(n).getText();
            if (!actualHeaderText.equals(expectedHeaderButtonsTexts[n])) {
                allNamesMatch = false;
                break;
            }
        }
        return allNamesMatch;
    }

}
