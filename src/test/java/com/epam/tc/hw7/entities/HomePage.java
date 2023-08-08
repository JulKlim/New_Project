package com.epam.tc.hw7.entities;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class HomePage extends WebPage {
    @FindBy(css = "#user-icon")
    public static Icon loginIcon;
    @FindBy(css = "#name")
    public static TextField userField;

    @FindBy(css = "#password")
    public static TextField passwordField;

    @FindBy(css = "#login-button")
    public static Button loginButton;

    @FindBy(css = "#user-name")
    public static Button username;

    @FindBy(xpath = "/html/body/header/div/nav/ul[1]/li[4]/a")
    public static Button headerMenuMetalsAnsColors;
}
