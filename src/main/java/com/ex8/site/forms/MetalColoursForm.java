package com.ex8.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.ex7.enums.SaladEnum;
import com.ex8.entities.MetalsColoursVegetables;
import org.openqa.selenium.support.FindBy;

public class MetalColoursForm extends Form {
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
    private CheckList<Enum> elementsCheckBoxList;

    @FindBy(css = "#summary-block p")
    private RadioButtons<Enum> radioNumbers;

    public void fillAndSumbit(MetalsColoursVegetables metalsColoursVegetables) {
        metalsColoursVegetables.getSummary().forEach(number -> radioNumbers.select(String.valueOf(number)));
        metalsColoursVegetables.getElements().forEach(element -> elementsCheckBoxList.select(element));
        dropdownColours.select(metalsColoursVegetables.getColor());
        dropdownMetals.select(metalsColoursVegetables.getMetals());
        metalsColoursVegetables.getVegetables().forEach(vegetable -> dropdownSalad.select(vegetable));
        dropdownSalad.select(SaladEnum.SALAD.text);
        submitButton.click();
    }
}
