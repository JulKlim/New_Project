package com.epam.tc.hw3.ex1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    final WebDriver driver;
    final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public boolean checkTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        return actualTitle.equals(expectedTitle);
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

    public boolean assertUsername(String expectedUsername) {
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
        return username.getText().equals(expectedUsername);
    }
}
