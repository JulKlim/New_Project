package com.epam.tc.hw6.common;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebDriverSetUp {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"isLocal", "hubAddress", "browserName"})
    public void setup(@Optional("false") final boolean isLocal, final String hubAddress, final String browserName) {
        DriverFabric driverFabric = new DriverFabric();
        try {
            driver = driverFabric.getWebdriver(isLocal, hubAddress, browserName);
            driver.manage().window().maximize();
        } catch (MalformedURLException malformedUrlException) {
            System.out.println("A malformed URL has occurred: " + malformedUrlException);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setContextAttribute(ITestContext context) {
        context.setAttribute("driver", driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
