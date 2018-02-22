package com.ex8.entities;

import com.epam.commons.DataClass;
import com.ex8.enums.AccountEnum;

public class User extends DataClass {

    private String login;
    private String password;
    private String user;

    public User(AccountEnum accountEnum) {
        this.login = accountEnum.login;
        this.password = accountEnum.password;
        this.user = accountEnum.user;
    }
}
