package com.templates.data;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class User {

    private String login;
    private String password;
    private String fullName;

    @Override
    public String toString() {
        return String.format("User: login - %s, password - %s, name - %s", login, password, fullName);
    }
}
