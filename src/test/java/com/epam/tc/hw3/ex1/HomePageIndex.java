package com.epam.tc.hw3.ex1;

import io.qameta.allure.Step;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageIndex {
    final WebDriver driver;
    final WebDriverWait wait;

    public HomePageIndex(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Checking number of images in index page")
    public boolean isImagesCountCorrect(int expectedNumberOfImages) {
        List<WebElement> images = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//*[contains(@class, 'benefit-icon')]")));

        return images.size() == expectedNumberOfImages;
    }

    @Step("Checking weather images in index page are displayed")
    public boolean imagesDisplayed() {
        List<WebElement> images = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//*[contains(@class, 'benefit-icon')]")));
        boolean imagesDisplayed = true;
        for (WebElement image : images) {
            if (!image.isDisplayed()) {
                imagesDisplayed = false;
            }
        }
        return imagesDisplayed;
    }

    @Step("Checking is texts count in index page correct")
    public boolean isTextsCountCorrect(int expectedNumberOfTexts) {
        List<WebElement> texts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".benefit-txt")));

        return texts.size() == expectedNumberOfTexts;
    }

    @Step("Checking weather texts in index page are correct")
    public boolean areTextsCorrect(String[] expectedTexts) {
        List<WebElement> texts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".benefit-txt")));
        boolean textMatch = true;
        for (int i = 0; i < texts.size(); i++) {
            String actualText = texts.get(i).getText();
            if (!actualText.equals(expectedTexts[i])) {
                textMatch = false;
            }
        }
        return textMatch;
    }
}
