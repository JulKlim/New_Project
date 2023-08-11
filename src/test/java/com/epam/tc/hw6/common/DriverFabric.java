package com.epam.tc.hw6.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFabric {
    public WebDriver getWebdriver(final boolean isLocal, final String hubAddress, @NonNull final String browserName)
            throws MalformedURLException {

        if (isLocal) {
            return WebDriverManager.getInstance(browserName).create();
        } else {
            Capabilities capabilities = null;
            if (browserName.toUpperCase(Locale.ROOT).equals("CHROME")) {
                capabilities = new ChromeOptions();
            } else if (browserName.toUpperCase(Locale.ROOT).equals("FIREFOX")) {
                capabilities = new FirefoxOptions();
            } else {
                throw new IllegalArgumentException("The browser name is not recognized: " + browserName);
            }
            return new RemoteWebDriver(new URL(hubAddress), capabilities);
        }
    }
}

/*public class DriverFabric {

    public WebDriver getWebdriver(final boolean isLocal, final String hubAddress, @NonNull final String browserName)
            throws MalformedURLException {

        if (isLocal) {
            return WebDriverManager.getInstance(browserName).create();
        } else {
            Capabilities capabilities = null;
            if (browserName.toUpperCase(Locale.ROOT).equals("CHROME")) {
                capabilities = new FirefoxOptions();
            } else if (browserName.toUpperCase(Locale.ROOT).equals("FIREFOX")) {
                capabilities = new FirefoxOptions();
            } else {
                System.err.println("The browser name '%s' is not recognized: " + browserName);
            }
            assert capabilities != null;
            return new RemoteWebDriver(new URL(hubAddress), capabilities);
        }
    }
}*/
