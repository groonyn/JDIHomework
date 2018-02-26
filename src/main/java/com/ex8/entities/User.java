package com.ex8.entities;

import com.ex8.enums.AccountEnum;

import static com.ex8.enums.AccountEnum.PITER_CHAILOVSKI;

public class User {
    public static final User piterChailovski = new User(PITER_CHAILOVSKI);

    private final String login;
    private final String password;
    private final String user;

    public User(AccountEnum accountEnum) {
        this.login = accountEnum.login;
        this.password = accountEnum.password;
        this.user = accountEnum.user;
    }
}