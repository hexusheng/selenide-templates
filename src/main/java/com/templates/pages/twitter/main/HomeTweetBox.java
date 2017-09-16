package com.templates.pages.twitter.main;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomeTweetBox extends ElementsContainer {

    @FindBy(css = "#tweet-box-home-timeline")
    public SelenideElement content;

    @FindBy(css = ".js-tweet-btn")
    public SelenideElement tweet;
}
