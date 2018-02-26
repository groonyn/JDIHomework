package com.ex8.site.sections;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.ex8.entities.User;
import com.ex8.site.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

public class HeaderSection extends Section {
    @FindBy(css = ".profile-photo")
    private Button loginButton;

    @FindBy(css = ".logout")
    private Button logout;

    @FindBy(css = ".form-horizontal")
    private LoginForm loginForm;

    @FindBy(css = ".m-l8")
    public HeaderMenu headerMenu;

    @FindBy(css = ".profile-photo span")
    private Text userInfo;

    public void login(User user) {
        loginButton.click();
        loginForm.loginAs(user);
    }

    public void checkUser(User user) {
        loginButton.should(Condition.text(user.getUser()));
    }

    public void logout() {
        loginButton.click();
        logout.click();
    }
}