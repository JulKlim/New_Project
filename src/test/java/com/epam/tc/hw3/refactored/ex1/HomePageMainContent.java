package com.epam.tc.hw3.refactored.ex1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class HomePageMainContent {
    final WebDriver driver;
    final WebDriverWait wait;
    final SoftAssert softAssert;


    public HomePageMainContent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.softAssert = new SoftAssert();
    }

    public void switchToIframe() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id, 'frame')]")));
        driver.switchTo().frame(iframe);
    }

    public void ifFrameButtonExists() {
        WebElement frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input#frame-button.btn.btn-info[value='Frame Button']")));
        softAssert.assertTrue(frameButton.isDisplayed());
        softAssert.assertAll();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
