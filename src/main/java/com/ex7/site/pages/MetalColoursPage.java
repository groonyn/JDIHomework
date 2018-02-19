package com.ex7.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.ex7.enums.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetalColoursPage extends WebPage {
    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    private Dropdown dropdownColours;

    @JDropdown(
            root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"))
    private Dropdown dropdownMetals;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"))
    private Dropdown dropdownSalad;

    @FindBy(css = "#submit-button")
    private Button submitButton;

    @FindBy(css = "#elements-checklist p label")
    private CheckList<ElementsEnum> elementsCheckBoxList;

    @FindBy(css = "#summary-block p")
    private RadioButtons<NumbersEnum> radioNumbers;

    @FindBy(css = ".results li")
    private TextList actualResults;

    public void clickRadioButtons(List<NumbersEnum> numbersEnum) {
        numbersEnum.forEach(numberEnum -> radioNumbers.select(String.valueOf(numberEnum.number)));
    }

    public void clickCheckboxButtons(List<ElementsEnum> elementsEnums) {
        elementsEnums.forEach(elementEnum -> elementsCheckBoxList.select(elementEnum.text));
    }

    public void clickDropdownColours(ColoursEnum coloursEnum) {
        dropdownColours.select(coloursEnum.text);
    }

    public void clickDropdownMetals(MetalsEnum metalsEnum) {
        dropdownMetals.select(metalsEnum.text);
    }

    public void clickDropdownSalad(List<SaladEnum> saladEnums) {
        saladEnums.forEach(saladEnum -> dropdownSalad.select(saladEnum.text));
        dropdownSalad.select(SaladEnum.SALAD.text);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void checkResult(List<String> expectedResult) {
        List<String> actualResultsList = new ArrayList();
        actualResults.getElements().toMap().keySet().forEach(item -> actualResultsList.add((String) item));
        Collections.sort(actualResultsList);
        Assert.assertEquals(expectedResult, actualResultsList);
    }
}
