package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.ex2.WebdriverSetUp;
import io.qameta.allure.Attachment;

public class ScreenshotUtils extends WebdriverSetUp {

    @Attachment(type = "image/png", value = "Screenshot on failure")
    public byte[] attachScreenshot(String attachmentName, byte[] source) {
        return source;
    }

}
