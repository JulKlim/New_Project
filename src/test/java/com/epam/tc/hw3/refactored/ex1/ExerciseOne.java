package com.epam.tc.hw3.refactored.ex1;

import com.epam.tc.hw2.ex1.WebdriverSetUp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ExerciseOne extends WebdriverSetUp {

    //1 Open test site by URL
    @Test(priority = 1)
    public void openHomePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openHomePage();
    }

    //2 Assert Browser title
    @Test(priority = 2)
    public void checkTitle() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkTitle("Home Page");
    }

    //3 Perform login
    @Test(priority = 3)
    public void performLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("Roman", "Jdi1234");
    }

    //4 Assert Username is logged
    @Test(priority = 4)
    public void assertUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.assertUsername("ROMAN IOVLEV");
    }

    //5 Assert that there are 4 items on the header section are displayed,
    //and they have proper
    //texts

    @Test(priority = 5)
    public void assertHeaderItems() {
        HomePageHeader homePageHeader = new HomePageHeader(driver);
        String[] expectedHeaderButtonsTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        homePageHeader.verifyItemsCount(4);
        homePageHeader.areItemsNamesCorrect(expectedHeaderButtonsTexts);
    }

    //6 Assert there are 4 images on the index page and all of them are displayed
    @Test(priority = 6)
    public void assertIconsCountAndDisplay() {
        HomePageIndex homePageIndex = new HomePageIndex(driver);
        homePageIndex.isImagesCountCorrect(4);
        homePageIndex.areImagesDisplayed();
    }

    //7 Assert there are 4 texts under icons, each of them contains proper text

    @Test(priority = 7)
    public void asserTexts() {
        HomePageIndex homePageIndex = new HomePageIndex(driver);
        homePageIndex.isTextsCountCorrect(4);

        String firstText = "To include good practices\nand ideas from successful\nEPAM project";
        String secondText = "To be flexible and\ncustomizable";
        String thirdText = "To be multiplatform";
        String fourText = "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";
        String[] expectedTexts = {firstText, secondText, thirdText, fourText};
        homePageIndex.areTextsCorrect(expectedTexts);
    }

    //8 Assert that iframe exists and contains Frame button

    @Test(priority = 8)
    public void checkIframe() {
        HomePageMainContent homePageMainContent = new HomePageMainContent(driver);

        //9 Switch to the iframe and check that there is
        //“Frame Button” in the iframe

        homePageMainContent.switchToIframe();
        homePageMainContent.ifFrameButtonExists();
    }

    //10 Switching to original window

    @Test(priority = 9)
    public void switchToIframe() {
        HomePageMainContent homePageMainContent = new HomePageMainContent(driver);
        homePageMainContent.switchToDefaultContent();
    }

    //11 Assert there are 5 items in the Left section displayed and contain proper texts

    @Test(priority = 10)
    public void itemsLeftSection() {
        HomePageLeftSideBar homePageLeftSideBar = new HomePageLeftSideBar(driver);
        homePageLeftSideBar.isItemsLeftSideBarCountCorrect(5);
        homePageLeftSideBar.areItemsLeftSideBarDisplayed();

        String[] expectedSections = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        homePageLeftSideBar.ifSectionNamesMatch(expectedSections);
    }

    //12 Closing browser
    @AfterTest
    public void closing() {
        driver.quit();
    }
}

