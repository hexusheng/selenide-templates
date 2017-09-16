package com.templates.pages.twitter.main;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class TimelineTweet extends ElementsContainer {

    @FindBy(css = ".stream-item-header .fullname")
    public SelenideElement name;

    @FindBy(css = ".js-tweet-text-container")
    public SelenideElement text;
}
