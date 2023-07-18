package com.epam.tc.hw3.ex2;

import io.qameta.allure.Attachment;

public class ScreenshotUtils extends WebdriverSetUp {

    @Attachment(type = "image/png", value = "Screenshot on failure")
    public byte[] attachScreenshot(String attachmentName, byte[] source) {
        return source;
    }

}
