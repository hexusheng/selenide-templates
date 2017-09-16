package com.templates.pages.twitter.main;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HeaderButtons extends ElementsContainer {

    @FindBy(css = ".js-login")
    public SelenideElement loginBtn;
}
