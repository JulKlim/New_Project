package com.epam.tc.hw3.ex1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePageMainContent {
    final WebDriver driver;
    final WebDriverWait wait;


    public HomePageMainContent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchToIframe() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id, 'frame')]")));
        driver.switchTo().frame(iframe);
    }

    public boolean ifFrameButtonExists() {
        WebElement frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input#frame-button.btn.btn-info[value='Frame Button']")));
        return frameButton.isDisplayed();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
