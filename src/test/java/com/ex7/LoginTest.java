package com.ex7;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.ex7.entities.Data;
import com.ex7.enums.ElementsEnum;
import com.ex7.enums.NumbersEnum;
import com.ex7.enums.SaladEnum;
import com.ex7.site.Site;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.ex7.enums.AccountEnum.PITER_CHAILOVSKI;
import static com.ex7.enums.ColoursEnum.RED;
import static com.ex7.enums.ElementsEnum.FIRE;
import static com.ex7.enums.ElementsEnum.WATER;
import static com.ex7.enums.MetalsEnum.SELEN;
import static com.ex7.enums.NumbersEnum.EIGHT;
import static com.ex7.enums.NumbersEnum.THREE;
import static com.ex7.enums.SaladEnum.CUCUMBER;
import static com.ex7.enums.SaladEnum.TOMATO;
import static com.ex7.site.Site.mainPage;
import static com.ex7.site.Site.metalColoursPage;
import static com.ex7.site.pages.MetalColoursPage.provideExpectedResult;
import static edu.emory.mathcs.backport.java.util.Arrays.asList;

public class LoginTest extends TestNGBase {
    private static Data data;

    @SuppressWarnings("unchecked generics array creation")
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(Site.class);
    }

    @SuppressWarnings("unchecked assigment")
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (method.getName().equals("login")) {
            data = new Data(asList(new NumbersEnum[]{THREE, EIGHT}),
                    asList(new ElementsEnum[]{WATER, FIRE}), RED, SELEN,
                    asList(new SaladEnum[]{CUCUMBER, TOMATO}));
        }
    }

    @Test
    public void login() {
        mainPage.open();
        mainPage.login(PITER_CHAILOVSKI.login, PITER_CHAILOVSKI.password).clickMetalColourLink();
        metalColoursPage.checkOpened();
        metalColoursPage.clickRadioButtons(data.getSummary());
        metalColoursPage.clickCheckboxButtons(data.getElements());
        metalColoursPage.clickDropdownColours(data.getColour());
        metalColoursPage.clickDropdownMetals(data.getMetals());
        metalColoursPage.clickDropdownSalad(data.getSalad());
        metalColoursPage.clickSubmitButton();
        metalColoursPage.checkResult(provideExpectedResult());
    }

}