package com.ex8.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.ex8.site.pages.MainPage;
import com.ex8.site.pages.MetalColoursPage;

@JSite("https://jdi-framework.github.io/tests")
public class Site extends WebSite {
    @JPage(url = "index.htm", title = "Index Page")
    public static MainPage mainPage;

    @JPage(url = "/page2.htm", title = "Metal and Colors")
    public static MetalColoursPage metalColoursPage;
}
