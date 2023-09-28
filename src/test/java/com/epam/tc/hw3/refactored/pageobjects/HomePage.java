package com.epam.tc.hw3.refactored.pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    final WebDriver driver;
    final WebDriverWait wait;
    final WebElement dropdownMenu;
    final WebElement menuService;
    final WebElement differentElements;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-icon")));
        this.menuService = driver.findElement(By.cssSelector(".menu-title[index='3']"));
        this.differentElements = driver.findElement(By.xpath(
                "//*[@id='mCSB_1_container']/ul/li[3]/ul/li[8]/a"));
    }

    public String checkTitle() {
        return driver.getTitle();
    }

    public HomePage openLoginForm() {
        dropdownMenu.click();
        return this;
    }


    public void openDifferentElements() {
        menuService.click();
        differentElements.click();
    }
}

