package com.ex7.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

public class MainPage extends WebPage {
    @FindBy(css = ".profile-photo")
    private Button loginButton;

    @FindBy(css = "#Login")
    private TextField login;

    @FindBy(css = "#Password")
    private TextField password;

    @FindBy(css = "[type=submit]")
    private Button submit;

    @FindBy(css = ".uui-header [href='page2.htm']")
    private Link metalColourLink;

    public void clickMetalColourLink() {
        metalColourLink.click();
    }

    public MainPage login(String login, String password) {
        this.clickLoginButton();
        this.login.input(login);
        this.password.input(password);
        this.submit.click();
        return this;
    }

    private void clickLoginButton() {
        loginButton.click();
    }
}
