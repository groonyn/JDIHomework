package com.ex7.entities;

import com.epam.commons.DataClass;
import com.ex7.enums.AccountEnum;

class User extends DataClass {

    private final String login;
    private final String password;
    private final String user;

    public User(AccountEnum accountEnum) {
        this.login = accountEnum.login;
        this.password = accountEnum.password;
        this.user = accountEnum.user;
    }
}
