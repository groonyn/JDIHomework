package com.ex8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.ex8.entities.Data;
import com.ex8.site.Site;
import com.ex8.utils.Utils;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ex8.enums.AccountEnum.PITER_CHAILOVSKI;
import static com.ex8.site.Site.mainPage;
import static com.ex8.site.Site.metalColoursPage;

public class LoginTestDataProvider extends TestNGBase {

    static List<Data> data;

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws IOException {

        WebSite.init(Site.class);
    }

    @BeforeMethod
    public void setUpMethod() {
        mainPage.open();
        // TODO builder pattern is okay, but
        // TODO 1. where is Entity Driving Testing approach ?
        // TODO 2. you should open the page via Menu class instead of direct link...
        mainPage.login(PITER_CHAILOVSKI.login, PITER_CHAILOVSKI.password).clickMetalColourLink();
        metalColoursPage.checkOpened();
    }

    @AfterMethod
    public void tearDownMethod() {
        mainPage.logout();
    }

    @DataProvider
    public Object[] data() throws IOException {
        return Utils.jsonGetData().toArray(); //array of objects and each object is Data
    }

    @Test(dataProvider = "data")
    public void login(Data data) {
        // TODO you should use Entity Driving testing, Form, Entities and so on...
        metalColoursPage.clickRadioButtons(data.getSummary());
        metalColoursPage.clickRadioButtons(data.getSummary());
        metalColoursPage.clickCheckboxButtons(data.getElements());
        metalColoursPage.clickDropdownColours(data.getColour());
        metalColoursPage.clickDropdownMetals(data.getMetals());
        metalColoursPage.clickDropdownSalad(data.getSalad());
        metalColoursPage.clickSubmitButton();
        metalColoursPage.checkResult(provideExpectedResult(data));
    }

    // TODO this should not be here cause this method has no relation to Tests as is.
    private Map<String, Object> provideExpectedResult(Data data) {
        Map<String, Object> expectedResultMap = new HashMap<>();
        expectedResultMap.put("Summary", String.valueOf(Utils.summOfList(data.getSummary())));
        expectedResultMap.put("Elements", data.getElements());
        expectedResultMap.put("Color", data.getColour());
        expectedResultMap.put("Metal", data.getMetals());
        expectedResultMap.put("Vegetables", data.getSalad());
        return expectedResultMap;
    }
}

