package com.epam.tc.hw4.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;


public class WebdriverSetUp {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public DifferentElementsMainContent differentElementsMainContent;
    public DifferentElementsLog differentElementsLog;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUpContext(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");


        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        differentElementsMainContent = new DifferentElementsMainContent(driver);
        differentElementsLog = new DifferentElementsLog(driver);
        context.setAttribute("driver", driver);
    }
}
