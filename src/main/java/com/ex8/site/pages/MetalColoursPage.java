package com.ex8.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.ex8.entities.Data;
import com.ex8.utils.Utils;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;

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
    private CheckList<Enum> elementsCheckBoxList;

    @FindBy(css = "#summary-block p")
    private RadioButtons<Enum> radioNumbers;

    @FindBy(css = ".results li")
    private TextList actualResults;

    public void clickRadioButtons(List<Integer> numbers) {
        numbers.forEach(number -> radioNumbers.select(String.valueOf(number)));
    }

    public void clickCheckboxButtons(List<String> elements) {
        elements.forEach(element -> elementsCheckBoxList.select(element));
    }

    public void clickDropdownColours(String colors) {
        dropdownColours.select(colors);
    }

    public void clickDropdownMetals(String metals) {
        dropdownMetals.select(metals);
    }

    public void clickDropdownSalad(List<String> vegetables) {
        vegetables.forEach(vegetable -> dropdownSalad.select(vegetable));
        dropdownSalad.select("Salad");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public static Map<String, Object> provideExpectedResult(Data data) {
        Map<String, Object> expectedResultMap = new HashMap<>();
        expectedResultMap.put("Summary", String.valueOf(Utils.summOfList(data.getSummary())));
        expectedResultMap.put("Elements", data.getElements());
        expectedResultMap.put("Color", data.getColor());
        expectedResultMap.put("Metal", data.getMetals());
        expectedResultMap.put("Vegetables", data.getVegetables());
        return expectedResultMap;
    }

    @SuppressWarnings("unchecked")
    public void checkResult(Map<String, Object> expectedResult) {
        List<String> actualResultList = new ArrayList<>();
        List<String> expectedResultList = new ArrayList<>();

        for (Object item : actualResults.getElements().toMap().keySet()) {
            String[] keyValueSet = ((String) item).split(": ");
            String value = keyValueSet[1];

            if (value.contains(",")) {
                List<String> listValue = Arrays.asList(value.split(", "));
                actualResultList.addAll(listValue);

            } else {
                actualResultList.add(value);
            }
        }

        for (Map.Entry<String, Object> entry : expectedResult.entrySet()) {
            if (entry.getValue() instanceof Iterable) {
                expectedResultList.addAll(((List<String>) entry.getValue()));
            } else {
                expectedResultList.add((String) entry.getValue());
            }
        }

        Collections.sort(expectedResultList);
        Collections.sort(actualResultList);

        Assert.assertEquals(expectedResultList, actualResultList);
    }
}
