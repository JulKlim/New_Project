package com.epam.tc.hw6.common;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class HomePageIndex {
    final WebDriver driver;
    final WebDriverWait wait;

    final SoftAssert softAssert;
    final List<WebElement> images;
    final List<WebElement> texts;

    public HomePageIndex(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.softAssert = new SoftAssert();
        this.images = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//*[contains(@class, 'benefit-icon')]")));
        this.texts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".benefit-txt")));
    }

    public int isImagesCountCorrect() {
        return images.size();
    }

    public boolean areImagesDisplayed() {
        boolean imagesDisplayed = true;
        for (WebElement image : images) {
            if (!image.isDisplayed()) {
                imagesDisplayed = false;
            }
        }
        return imagesDisplayed;
    }

    public int isTextsCountCorrect() {
        return texts.size();
    }

    public boolean areTextsCorrect(String[] expectedTexts) {
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
