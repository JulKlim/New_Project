package com.epam.tc.hw4.ex2;

import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    final WebDriver driver;
    final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Open Home Page")
    public void openHomePage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Step("Check title 'Home Page'")
    public boolean checkTitle(String expectedTitle) {
        //wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        return actualTitle.equals(expectedTitle);
    }

    @Step("Log in with username{0} and password {1}")
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

    @Step("Check username is correct")
    public boolean assertUsername(String expectedUsername) {
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
        return username.getText().equals(expectedUsername);
    }

    @Step("Open the Different Elements page")
    public void openDifferentElements() {
        WebElement menuService = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".menu-title[index='3']")));
        menuService.click();

        WebElement differentElements = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.linkText("Different elements")));
        differentElements.click();
    }

}
