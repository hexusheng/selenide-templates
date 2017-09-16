package com.templates.pages.twitter.login;

import com.templates.pages.twitter.main.HeaderButtons;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = ".StreamsHero-buttonContainer")
    public HeaderButtons header;

    @FindBy(css = ".LoginDialog-content")
    public LoginForm loginForm;
}
