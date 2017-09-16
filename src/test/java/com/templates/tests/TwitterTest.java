package com.templates.tests;

import com.templates.helpers.Functions;
import com.templates.listeners.AllureFailReporter;
import com.templates.pages.twitter.login.LoginPage;
import com.templates.pages.twitter.main.MainPage;
import com.templates.testcases.TwitterTestCase;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;

@Listeners({AllureFailReporter.class})
public class TwitterTest extends TwitterTestCase {

    @Getter
    @Setter
    @Accessors(fluent = true)
    private LoginPage twitterHomePage;

    @Getter
    @Setter
    @Accessors(fluent = true)
    private MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    @Step("Startup settings")
    public void setUp() {
        browser = "chrome";
        baseUrl = "https:/twitter.com";
    }

    @Test(groups = "all", description = "Login")
    public void logIn() throws Exception {
        twitterHomePage(open("/", LoginPage.class));
        twitterHomePage().header.loginBtn.shouldBe(visible).click();

        mainPage(twitterHomePage().loginForm.fill(user));
        mainPage().isOpen();
    }

    @Test(groups = "all", description = "Type tweet")
    public void tweet() throws Exception {

        String message = "Hello twitter N" + new Random().nextInt(100);
        twitterHomePage(open("/", LoginPage.class));
        twitterHomePage().header.loginBtn.shouldBe(visible).click();

        mainPage(twitterHomePage().loginForm.fill(user));
        mainPage().isOpen();
        mainPage().makeTweet(message);
        // TODO: 17.09.17 Found not all displayed messages
        Assert.assertTrue(Functions.exec().waitFor(() ->
                        mainPage().timelineTweets.stream()
                                .anyMatch(tweet -> tweet.name.getText().contains(user.fullName())
                                        && tweet.text.getText().equals(message)), 5, 5),
                "Cant find our tweet");
        allure().makeScreenShot("Twitted message");

    }
}
