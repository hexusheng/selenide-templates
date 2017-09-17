package com.templates.testcases;

import com.templates.data.User;
import com.templates.data.Users;
import com.templates.helpers.AllureThings;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class TwitterTestCase {

    protected final User user = Users.getOne();

    @Getter(lazy = true)
    @Accessors(fluent = true)
    private final AllureThings allure = AllureThings.exec();

    @BeforeMethod(alwaysRun = true)
    @Step("Startup settings")
    public void setUp() {
        browser = "chrome";
        baseUrl = "https://twitter.com";
    }
}
