package com.epam.tc.hw7.testscripts;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.HomePage;
import com.epam.tc.hw7.entities.JdiSite;
import com.epam.tc.hw7.entities.MetalsColorsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MetalsAndColorsTests {
    @BeforeClass
    public static void setUp() {
        PageFactory.initElements(JdiSite.class);
        WebDriverFactory.getDriver(); // Open browser (by default, Chrome)
    }

    @Test (priority = 1)
    public void loginTest() {
        JdiSite jdiSite = new JdiSite();
        jdiSite.open();

        HomePage.loginIcon.click();
        HomePage.userField.input("Roman");
        HomePage.passwordField.input("Jdi1234");
        HomePage.loginButton.click();

        assertThat(HomePage.username.getText()).isEqualTo("ROMAN IOVLEV");
        HomePage.headerMenuMetalsAnsColors.click();
    }

    @Test (priority = 2)
    public void openMetalsColorsPageTest() {
        assertThat(MetalsColorsPage.getTitle().equals("Metal and Colors"));
    }

    @Test (priority = 3)
    public void selectRadioButtons() {
        MetalsColorsPage.selectOddNumber(5);
        MetalsColorsPage.selectEvenNumber(6);
        MetalsColorsPage.calculateButton.click();
    }

    @Test (priority = 4)
    public void selectElements() {
        String[] elements = {"Water", "Fire"};
        MetalsColorsPage.selectElements(elements);
    }

    @Test (priority = 5)
    public void selectColor() {
        MetalsColorsPage.selectColor("Green");
    }

    //@AfterClass
    public static void tearDown() {
        WebDriverFactory.quit();
    }
}
