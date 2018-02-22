package com.ex8.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.ex8.entities.User;
import com.ex8.site.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

public class MainPage extends WebPage {
    @FindBy(css = ".profile-photo")
    private Button loginButton;

    @FindBy(css = ".uui-header [href='page2.htm']")
    private Link metalColourLink;

    @FindBy(css = ".logout")
    private Button logout;

    @FindBy(css = ".form-horizontal")
    private LoginForm loginForm;

    public void clickMetalColourLink() {
        metalColourLink.click();
    }

    public MainPage login(User user) {
        loginButton.click();
        loginForm.loginAs(user);
        return this;
    }

    public void logout() {
        loginButton.click();
        logout.click();
    }
}

