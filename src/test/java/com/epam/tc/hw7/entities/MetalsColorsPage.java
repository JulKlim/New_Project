package com.epam.tc.hw7.entities;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MetalsColorsPage extends WebPage {

    @FindBy(css = "#odds-selector")
    public static RadioButtons radioButtonsOddNumbers;

    @FindBy(css = "#even-selector")
    public static WebList radioButtonsEvenNumbers;

    @FindBy(css = "#calculate-button")
    public static Button calculateButton;


    @FindBy(css = "#elements-checklist")
    public static Checklist elementsChecklist;

    @FindBy(css = "#colors")
    public static Dropdown colorsDropdown;

    @FindBy(css = "#metals")
    public static Dropdown metalsDropdown;

    @FindBy(css = "#salad-dropdown")
    public static Dropdown vegetablesDropdown;

    @FindBy(css = "#submit-button")
    public static Button submitButton;

    public static void selectOddNumber(int oddNumber) {
        WebElement number = radioButtonsOddNumbers.find((
                By.xpath("//label[contains(text(), '" + oddNumber + "')]")));
        number.click();
    }

    public static void selectEvenNumber(int evenNumber) {
        WebElement number = radioButtonsEvenNumbers.find(
                By.xpath("//label[contains(text(), '" + evenNumber + "')]"));
        number.click();
    }

    public static void selectElements(List<String> elements) {
        for (String element : elements) {
            WebElement checkbox = elementsChecklist.find(
                    By.xpath("//label[contains(text(), '" + element + "')]"));
            checkbox.click();
        }
    }

    public static void selectColor(String color) {
        colorsDropdown.expand();
        WebElement colorFromDropdown = colorsDropdown.find(
                By.xpath("//span[contains(text(), '" + color + "')]"));
        colorFromDropdown.click();

    }

    public static void selectMetal(String metal) {
        metalsDropdown.expand();
        WebElement metalFromDropdown = metalsDropdown.find(By.xpath(
                "//div/div//ul//li//a//span[contains(text(), '" + metal + "')]"));
        metalFromDropdown.click();
    }

    public static void selectVegetables(List<String> vegetables) {
        vegetablesDropdown.expand();
        vegetablesDropdown.find(By.xpath(
                "//ul//li//label[contains(text(), 'Vegetables')]")).click();
        for (String vegetable : vegetables) {
            WebElement checkboxVeg = vegetablesDropdown.find(By.xpath(
                    "//ul//li//label[contains(text(), '" + vegetable + "')]"));
            checkboxVeg.click();
        }
    }

}
