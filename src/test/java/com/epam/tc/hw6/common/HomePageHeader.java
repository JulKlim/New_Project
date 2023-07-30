package com.epam.tc.hw6.common;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class HomePageHeader {
    final WebDriver driver;
    final WebDriverWait wait;
    final SoftAssert softAssert;
    final List<WebElement> headerButtons;


    public HomePageHeader(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.softAssert = new SoftAssert();
        this.headerButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8:first-of-type>li>a")));
    }

    public int verifyItemsCount() {
        return headerButtons.size();
    }

    public boolean areItemsNamesCorrect(String[] expectedHeaderButtonsTexts) {
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
