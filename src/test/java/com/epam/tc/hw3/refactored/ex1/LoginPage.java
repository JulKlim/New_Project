package com.epam.tc.hw3.refactored.ex1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class LoginPage {
    final WebDriver driver;
    final WebDriverWait wait;
    final SoftAssert softAssert;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.softAssert = new SoftAssert();

    }

    public void openHomePage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void checkTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle);
    }

    public void performLogin(String username, String password) {
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-icon")));
        dropdownMenu.click();
        WebElement loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
        loginField.sendKeys(username);
        WebElement passField = driver.findElement(By.cssSelector("#password"));
        passField.sendKeys(password);
        WebElement enter = driver.findElement(By.cssSelector("#login-button"));
        enter.click();
    }

    public void assertUsername(String expectedUsername) {
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
        softAssert.assertEquals(username.getText(), expectedUsername);
    }
}
