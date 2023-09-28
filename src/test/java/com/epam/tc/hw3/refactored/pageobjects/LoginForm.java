package com.epam.tc.hw3.refactored.pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginForm {
    final WebDriver driver;
    final WebDriverWait wait;
    final WebElement loginField;
    final WebElement passField;
    final WebElement enter;
    final WebElement username;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginField = driver.findElement(By.cssSelector("#name"));
        this.passField = driver.findElement(By.cssSelector("#password"));
        this.enter = driver.findElement(By.cssSelector("#login-button"));
        this.username = driver.findElement(By.cssSelector("#user-name"));
    }

    public LoginForm performLogin(String username, String password) {
        loginField.sendKeys(username);
        passField.sendKeys(password);
        enter.click();
        return this;
    }

    public String assertUsername() {
        return username.getText();
    }
}
