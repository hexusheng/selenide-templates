package com.templates.testcases;

import com.templates.data.User;
import com.templates.data.Users;
import com.templates.helpers.AllureThings;
import lombok.Getter;
import lombok.experimental.Accessors;

public class TwitterTestCase {

    protected final User user = Users.getOne();

    @Getter(lazy = true)
    @Accessors(fluent = true)
    private final AllureThings allure = AllureThings.exec();
}
