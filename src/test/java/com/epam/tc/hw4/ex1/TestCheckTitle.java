package com.epam.tc.hw4.ex1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw4.ex2.WebdriverSetUp;
import org.testng.annotations.Test;

public class TestCheckTitle extends WebdriverSetUp {

    //2 Assert Browser title
    @Test(priority = 2)
    public void checkTitle() {
        LoginPage loginPage = new LoginPage(driver);
        boolean isTitleCorrect = loginPage.checkTitle("Home");
        assertThat(isTitleCorrect).as("Title is 'Home Page'").isTrue();
    }
}
