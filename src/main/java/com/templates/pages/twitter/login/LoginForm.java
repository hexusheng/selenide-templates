package com.templates.pages.twitter.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.templates.data.User;
import com.templates.helpers.AllureThings;
import com.templates.pages.twitter.main.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends ElementsContainer {

    @FindBy(css = ".LoginForm-username input")
    private SelenideElement login;

    @FindBy(css = ".LoginForm-password input")
    private SelenideElement password;

    @FindBy(css = ".js-submit")
    private SelenideElement submit;

    @Step("Fill login form")
    public MainPage fill(User user) {
        login.shouldBe(Condition.visible).sendKeys(user.login());
        password.sendKeys(user.password());
        AllureThings.exec().makeScreenShot("Filled form");
        submit.click();
        return Selenide.page(MainPage.class);
    }
}
