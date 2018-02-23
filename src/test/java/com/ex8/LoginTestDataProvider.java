package com.ex8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.ex8.entities.Data;
import com.ex8.entities.User;
import com.ex8.site.Site;
import com.ex8.utils.Utils;
import org.testng.annotations.*;

import java.io.IOException;

import static com.ex8.enums.AccountEnum.PITER_CHAILOVSKI;
import static com.ex8.enums.MenuEnum.METALSCOLORS;
import static com.ex8.site.Site.mainPage;
import static com.ex8.site.Site.metalColoursPage;
import static com.ex8.site.pages.MetalColoursPage.provideExpectedResult;

public class LoginTestDataProvider extends TestNGBase {

    @SuppressWarnings("unchecked generics array creation")
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(Site.class);
    }

    @BeforeMethod
    public void setUpMethod() {
        mainPage.open();
        mainPage.login(new User(PITER_CHAILOVSKI));
        mainPage.headerMenu.selectMenu(METALSCOLORS);
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
        metalColoursPage.clickRadioButtons(data.getSummary());
        metalColoursPage.clickRadioButtons(data.getSummary());
        metalColoursPage.clickCheckboxButtons(data.getElements());
        metalColoursPage.clickDropdownColours(data.getColor());
        metalColoursPage.clickDropdownMetals(data.getMetals());
        metalColoursPage.clickDropdownSalad(data.getVegetables());
        metalColoursPage.clickSubmitButton();
        metalColoursPage.checkResult(provideExpectedResult(data));
    }
}
