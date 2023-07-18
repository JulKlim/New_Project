package com.epam.tc.hw2.ex1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class ExerciseOne extends WebdriverSetUp {

    //1 Open test site by URL
    @Test(priority = 1)
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
    @Test(priority = 4)
    public void assertUsername() {
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
        String expectedUsername = "ROMAN IOVLEV";
        assertThat(username.getText()).isEqualTo(expectedUsername);
    }
    //5 Assert that there are 4 items on the header section are displayed,
    //and they have proper
    //texts

    @Test(priority = 5)
    public void assert4Items() {
        List<WebElement> headerButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8:first-of-type>li>a")));
        assertThat(headerButtons.size()).isEqualTo(4);

        String[] expectedHeaderButtonsTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int n = 0; n < headerButtons.size(); n++) {
            String actualHeaderText = headerButtons.get(n).getText();
            assertThat(actualHeaderText).isEqualTo(expectedHeaderButtonsTexts[n]);
        }
    }

    //6 Assert there are 4 images on the index page and all of them are displayed
    @Test(priority = 6)
    public void assert4Images() {
        List<WebElement> images = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//*[contains(@class, 'benefit-icon')]")));

        assertThat(images.size()).isEqualTo(4);
        for (WebElement image : images) {
            assertThat(image.isDisplayed()).isTrue();
        }
    }

    //7 Assert there are 4 texts under icons, each of them contains proper text

    @Test(priority = 7)
    public void asser4Texts() {
        List<WebElement> texts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".benefit-txt")));

        assertThat(texts.size()).isEqualTo(4);

        String firstText = "To include good practices\nand ideas from successful\nEPAM project";
        String secondText = "To be flexible and\ncustomizable";
        String thirdText = "To be multiplatform";
        String fourText = "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";
        String[] expectedTexts = {firstText, secondText, thirdText, fourText};

        for (int i = 0; i < texts.size(); i++) {
            String actualText = texts.get(i).getText();
            assertThat(actualText).isEqualTo(expectedTexts[i]);
        }
    }

    //8 Assert that iframe exists and contains Frame button

    @Test(priority = 8)
    public void checkIframe() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id, 'frame')]")));

        assertThat(iframe).isNotNull();
    }

    //9 Switch to the iframe and check that there is
    //“Frame Button” in the iframe

    @Test(priority = 9)
    public void switchToIframe() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id, 'frame')]")));
        driver.switchTo().frame(iframe);
        WebElement frameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input#frame-button.btn.btn-info[value='Frame Button']")));
        assertThat(frameButton).isNotNull();

        //10 Switching to original window
        driver.switchTo().defaultContent();
    }

    //11 Assert there are 5 items in the Left section displayed and contain proper texts

    @Test(priority = 10)
    public void itemsLeftSection() {
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.sidebar-menu.left")));
        List<WebElement> sectionsOnTheLeft = sidebar.findElements(
                By.xpath(".//li[@index >= '1' and @index <= '5' and not(ancestor::li)]"));

        assertThat(sectionsOnTheLeft.size()).isEqualTo(5);

        for (WebElement section : sectionsOnTheLeft) {
            boolean isSectionDisplayed = section.isDisplayed();
            assertThat(isSectionDisplayed).isTrue();
        }

        String[] expectedSections = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        for (int j = 0; j < sectionsOnTheLeft.size(); j++) {
            String actualSectionText = sectionsOnTheLeft.get(j).getText();
            assertThat(actualSectionText).isEqualTo(expectedSections[j]);
        }
    }

    //12 Closing browser
    @AfterTest
    public void closing() {
        driver.close();
    }
}

