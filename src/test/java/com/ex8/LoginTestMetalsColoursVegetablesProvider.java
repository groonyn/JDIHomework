package com.ex8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.ex8.entities.MetalsColoursVegetables;
import com.ex8.site.Site;
import com.ex8.utils.Utils;
import org.testng.annotations.*;

import java.io.IOException;

import static com.ex8.entities.User.piterChailovski;
import static com.ex8.enums.MenuEnum.METALSCOLORS;
import static com.ex8.site.sections.MetalColoursResultSection.provideExpectedResult;

public class LoginTestMetalsColoursVegetablesProvider extends TestNGBase {

    @SuppressWarnings("unchecked generics array creation")
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(Site.class);
    }

    @BeforeMethod
    public void setUpMethod() {
        Site.homePage.open();
        Site.homePage.checkOpened();
    }

    @AfterMethod
    public void tearDownMethod() {
        Site.metalColoursPage.headerSection.logout();
    }

    @DataProvider
    public Object[] data() throws IOException {
        return Utils.jsonGetData().toArray(); //array of objects and each object is MetalsColoursVegetables
    }

    @Test(dataProvider = "data")
    public void checkMetalsColoursUsability(MetalsColoursVegetables metalsColoursVegetablesData) {
        //1 Login on JDI site as User
        Site.homePage.headerSection.login(piterChailovski);
        Site.homePage.headerSection.checkUser(piterChailovski);

        //2 Open Metals & Colors page by Header headerMenu
        Site.homePage.headerSection.headerMenu.selectMenu(METALSCOLORS);
        Site.metalColoursPage.checkOpened();

        //3 Fill form Metals & Colors with DataProvider
        Site.metalColoursPage.metalColoursForm.fillAndSumbit(metalsColoursVegetablesData);

        //4 Result sections should contains metalsColoursVegetables from DataProvider
        Site.metalColoursPage.metalColoursResultSection.checkResult(provideExpectedResult(metalsColoursVegetablesData));
    }
}