package com.epam.tc.hw3.ex1;

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
        boolean isTitleCorrect = loginPage.checkTitle("Home Page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isTitleCorrect, "Title is 'Home Page'");
        softAssert.assertAll();
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
        boolean isUsernameCorrect = loginPage.assertUsername("ROMAN IOVLEV");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isUsernameCorrect, "Username is 'ROMAN IOVLEV'");
        softAssert.assertAll();
    }

    //5 Assert that there are 4 items on the header section are displayed,
    //and they have proper
    //texts

    @Test(priority = 5)
    public void assertHeaderItems() {
        HomePageHeader homePageHeader = new HomePageHeader(driver);
        String[] expectedHeaderButtonsTexts = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePageHeader.isItemsCountCorrect(
                4), "Items count is correct");
        softAssert.assertTrue(
                homePageHeader.isItemsNamesCorrect(expectedHeaderButtonsTexts), "Items' names are correct");
        softAssert.assertAll();
    }

    //6 Assert there are 4 images on the index page and all of them are displayed
    @Test(priority = 6)
    public void assertIconsCountAndDisplay() {
        HomePageIndex homePageIndex = new HomePageIndex(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue((
                homePageIndex.isImagesCountCorrect(4)), "Images count is correct");
        softAssert.assertTrue((homePageIndex.imagesDisplayed()));
        softAssert.assertAll();
    }

    //7 Assert there are 4 texts under icons, each of them contains proper text

    @Test(priority = 7)
    public void asserTexts() {
        HomePageIndex homePageIndex = new HomePageIndex(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue((
                homePageIndex.isTextsCountCorrect(4)), "Images count is correct");

        String firstText = "To include good practices\nand ideas from successful\nEPAM project";
        String secondText = "To be flexible and\ncustomizable";
        String thirdText = "To be multiplatform";
        String fourText = "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";
        String[] expectedTexts = {firstText, secondText, thirdText, fourText};
        softAssert.assertTrue((homePageIndex.areTextsCorrect(expectedTexts)), "Texts are correct");
        softAssert.assertAll();
    }

    //8 Assert that iframe exists and contains Frame button

    @Test(priority = 8)
    public void checkIframe() {
        HomePageMainContent homePageMainContent = new HomePageMainContent(driver);
        SoftAssert softAssert = new SoftAssert();

        //9 Switch to the iframe and check that there is
        //“Frame Button” in the iframe

        homePageMainContent.switchToIframe();
        boolean ifFrameButtonExists = homePageMainContent.ifFrameButtonExists();
        softAssert.assertTrue(ifFrameButtonExists, "Iframe button exists");
        softAssert.assertAll();
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue((homePageLeftSideBar.isItemsLeftSideBarCountCorrect(
                5)), "Items count on left-side bar is correct");
        softAssert.assertTrue(
                (homePageLeftSideBar.areItemsLeftSideBarDisplayed()), "Items on left-side bar displayed");

        String[] expectedSections = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        softAssert.assertTrue(
                (homePageLeftSideBar.ifSectionNamesMatch(expectedSections)), "Items on left-side bar displayed");
        softAssert.assertAll();
    }

    //12 Closing browser
    @AfterTest
    public void closing() {
        driver.quit();
    }
}

