package com.templates.tests;

import com.codeborne.selenide.testng.BrowserPerTest;
import com.templates.helpers.Functions;
import com.templates.listeners.AllureFailReporter;
import com.templates.pages.twitter.login.LoginPage;
import com.templates.pages.twitter.main.MainPage;
import com.templates.testcases.TwitterTestCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

@Getter
@Setter
@Feature("Twitter")
@Story("Simple UI tests")
@Accessors(fluent = true)
@Listeners({AllureFailReporter.class, BrowserPerTest.class})
public class TwitterTest extends TwitterTestCase {

    private LoginPage twitterHomePage;
    private MainPage mainPage;

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
        refresh();
        Assert.assertTrue(Functions.exec().waitFor(
                () -> mainPage().messageExistInTimeline(user.fullName(), message), 5, 5),
                "Cant find our tweet");
        allure().makeScreenShot("Twitted message");

    }
}
