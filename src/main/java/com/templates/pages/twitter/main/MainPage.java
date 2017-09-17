package com.templates.pages.twitter.main;

import com.codeborne.selenide.SelenideElement;
import com.templates.helpers.AllureThings;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class MainPage {

    @FindBy(css = ".tweet")
    private List<SelenideElement> timelineTweets;

    @FindBy(css = ".home-tweet-box")
    private HomeTweetBox homeTweetBox;

    @Step("Home page is open")
    public void isOpen() {
        homeTweetBox.content.shouldBe(visible);
        AllureThings.exec().makeScreenShot("Main Page");
    }

    @Step("Type tweet")
    public void makeTweet(String tweetText) {
        homeTweetBox.content.click();
        homeTweetBox.content.sendKeys(tweetText);
        homeTweetBox.tweet.waitUntil(enabled, 2000).click();
        homeTweetBox.tweet.waitUntil(disappear, 4000);
    }

    @Step("Check message in timeline")
    public Boolean messageExistInTimeline(String userName, String message) {
        return timelineTweets.stream()
                .anyMatch(tweet -> tweet.$(".fullname").has(text(userName))
                        && tweet.$(".js-tweet-text-container").has(text(message)));
    }
}
