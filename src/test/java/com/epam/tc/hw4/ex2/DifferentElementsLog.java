package com.epam.tc.hw4.ex2;

import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsLog {

    final WebDriver driver;
    final WebDriverWait wait;

    public DifferentElementsLog(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Checking a log for Water checkbox")
    public boolean isLogRowForWaterDisplayed(String logForWater) {
        WebElement waterLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForWater + "')]"))
        );
        return waterLog.isDisplayed();
    }

    @Step("Checking a log for Wind checkbox")
    public boolean isLogRowForWindDisplayed(String logForWind) {
        WebElement windLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForWind + "')]")));
        return windLog.isDisplayed();
    }

    @Step("Checking a log for radio button Selen")
    public boolean isLogRowRadioDisplayed(String logForSelen) {
        WebElement selenLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForSelen + "')]")));

        return selenLog.isDisplayed();
    }

    @Step("SChecking a log for color Yellow from dropdown")
    public boolean isLogDropdownDisplayed(String logForYellow) {
        WebElement yellowLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForYellow + "')]")));
        return yellowLog.isDisplayed();
    }
}
