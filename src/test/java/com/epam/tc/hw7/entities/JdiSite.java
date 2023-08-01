package com.epam.tc.hw7.entities;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite extends WebPage {
    // Define URL and Title for the login page
    @Url("/index.html")
    @Title("Home Page")
    public static HomePage homePage;

    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;
}
