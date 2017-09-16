package com.templates.pages.twitter.main;

import com.codeborne.selenide.Condition;
import com.templates.helpers.AllureThings;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(css = ".js-stream-item")
    public List<TimelineTweet> timelineTweets;

    @FindBy(css = ".home-tweet-box")
    private HomeTweetBox homeTweetBox;

    @Step("Home page is open")
    public void isOpen() {
        homeTweetBox.content.shouldBe(Condition.visible);
        AllureThings.exec().makeScreenShot("Main Page");
    }

    @Step("Type tweet")
    public void makeTweet(String tweetText) {
        homeTweetBox.content.click();
        homeTweetBox.content.sendKeys(tweetText);
        homeTweetBox.tweet.waitUntil(Condition.enabled, 2000).click();
        homeTweetBox.tweet.waitUntil(Condition.disappear, 2000);
    }
}
