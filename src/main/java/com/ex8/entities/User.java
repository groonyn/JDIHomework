package com.ex8.entities;

import com.ex8.enums.AccountEnum;

public class User {

    private final String login;
    private final String password;
    private final String user;

    public User(AccountEnum accountEnum) {
        this.login = accountEnum.login;
        this.password = accountEnum.password;
        this.user = accountEnum.user;
    }
}