package com.epam.tc.hw3.refactored.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class WebdriverSetUp {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomePageHeader homePageHeader;
    public HomePageIndex homePageIndex;
    public HomePageMainContent homePageMainContent;
    public HomePageLeftSideBar homePageLeftSideBar;
    public HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homePageHeader = new HomePageHeader(driver);
        homePageIndex = new HomePageIndex(driver);
        homePageMainContent = new HomePageMainContent(driver);
        homePageLeftSideBar = new HomePageLeftSideBar(driver);
    }
}
