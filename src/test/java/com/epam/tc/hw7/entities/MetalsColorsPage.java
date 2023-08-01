package com.epam.tc.hw7.entities;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.channels.Selector;
import java.util.List;

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

    public static void selectOddNumber(int oddNumber){
        WebElement number = radioButtonsOddNumbers.find((
                By.xpath("//label[contains(text(), '" + oddNumber + "')]")));
        number.click();
    }

    public static void selectEvenNumber(int evenNumber){
        WebElement number = radioButtonsEvenNumbers.find(
                By.xpath("//label[contains(text(), '" + evenNumber + "')]"));
        number.click();
    }

    public static void selectElements(String[] elements){
        for (String element: elements){
            WebElement checkbox = elementsChecklist.find(
                    By.xpath("//label[contains(text(), '" + element + "')]"));
            checkbox.click();
        }
    }

    public static void selectColor(String color){
        colorsDropdown.expand();
        colorsDropdown.find(By.xpath("//label[contains(text(), ' + element + ')]"));
    }

}
