package com.epam.tc.hw3.ex2;

import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DifferentElementsMainContent {
    final WebDriver driver;
    final WebDriverWait wait;

    public DifferentElementsMainContent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Select checkboxes Water and Wind")
    public void selectWaterAndWind() {
        WebElement checkboxWater = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='checkbox-row']/*[1]")));
        if (checkboxWater.getText().equals("Water")) {
            checkboxWater.click();
        }

        WebElement checkboxWind = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='checkbox-row']/*[3]")));
        if (checkboxWind.getText().equals("Wind")) {
            checkboxWind.click();
        }
    }

    @Step("Select radio button Selen")
    public void selectRadioSelen() {
        WebElement radioSelen = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("div:nth-child(3) > label:nth-child(4)")));
        if (radioSelen.getText().equals("Selen")) {
            radioSelen.click();
        }
    }

    @Step("Select yellow color from dropdown")
    public void selectDropdownYellow() {
        WebElement colorsDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".colors")));
        colorsDropdown.click();

        WebElement yellowColor = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//select[@class='uui-form-element']/*[4]")));
        if (yellowColor.getText().equals("Yellow")) {
            yellowColor.click();
        }
    }

}
