package com.epam.tc.hw4.ex2;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ScreenshotListener implements ITestListener {

    public WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");

        if (driver != null) {
            System.out.println("Test case failed");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ScreenshotUtils screenshotUtils = new ScreenshotUtils();
            screenshotUtils.attachScreenshot("Screenshot on failure", screenshot);
        } else {
            System.err.println("Driver is not found");
        }
    }
}
