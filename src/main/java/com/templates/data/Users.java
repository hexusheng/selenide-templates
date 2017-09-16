package com.templates.data;

import java.util.Arrays;
import java.util.List;

public class Users {

    private static List<User> users;

    static {
        users = Arrays.asList(
                new User()
                        .login("mail@mail.mail")
                        .password("password")
                        .fullName("name")
        );
    }

    public static User getOne() {
        return users.get(0);
    }
}
