package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.ex1.WebdriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ExcerciseTwo extends WebdriverSetUp {

    //1 Open test site by URL
    @Test (priority = 1)
    public void openNewPage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    //2 Assert Browser title
    @Test(priority = 2)
    public void checkTitle() {
        String expectedTitle = "Home Page";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).as("Title is 'Home Page'").isEqualTo(expectedTitle);
    }

    //3 Perform login
    @Test(priority = 3)
    public void performLogin() {

        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-icon")));
        dropdownMenu.click();
        WebElement loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
        loginField.sendKeys("Roman");
        WebElement passField = driver.findElement(By.cssSelector("#password"));
        passField.sendKeys("Jdi1234");
        WebElement enter = driver.findElement(By.cssSelector("#login-button"));
        enter.click();
    }

    //4 Assert Username is logged
    @Test (priority = 4)
    public void assertUsername() {
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
        String expectedUsername = "ROMAN IOVLEV";
        assertThat(username.getText()).isEqualTo(expectedUsername);
    }

    //5 Open through the header menu Service -> Different
    //Elements Page

    @Test (priority = 5)
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

    //6 Select checkboxes Water and Wind
    @Test(priority = 6)
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

    //7 Select radio Selen
    @Test(priority = 7)
    public void selectRadioSelen() {
        WebElement radioSelen = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("div:nth-child(3) > label:nth-child(4)")));
        if (radioSelen.getText().equals("Selen")) {
            radioSelen.click();
        }
    }

    //8 Select in dropdown Yellow
    @Test(priority = 8)
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

    //9.1 Assert that for each checkbox there is an individual log
    //row and value is corresponded to the status
    //of checkbox
    @Test(priority = 9)
    public void logRowForCheckbox() {
        String logForWater = "Water: condition changed to true";
        WebElement waterLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForWater + "')]"))
        );
        assertThat(waterLog.isDisplayed())
                .as("Water log is displayed")
                .isTrue();

        String logForWind = "Wind: condition changed to true";
        WebElement windLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForWind + "')]")));

        assertThat(windLog.isDisplayed())
                .as("Wind log is displayed")
                .isTrue();
    }

    //9.2 for radio button there is a log row and value
    //is corresponded to the status of radio button
    @Test(priority = 10)
    public void logRowRadio() {
        String logForSelen = "metal: value changed to  Selen";
        WebElement selenLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForSelen + "')]")));

        assertThat(selenLog.isDisplayed())
                .as("Selen log is displayed")
                .isTrue();
    }

    //9.3 for dropdown there is a log row and value is
    //corresponded to the selected value.
    @Test(priority = 11)
    public void logDropdown() {
        String logForYellow = "Colors: value changed to Yellow";
        WebElement yellowLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + logForYellow + "')]")));

        assertThat(yellowLog.isDisplayed())
                .as("Yellow log is displayed")
                .isTrue();
    }

    //10 Closing browser
    @AfterTest
    public void closing() {
        driver.close();
    }
}
