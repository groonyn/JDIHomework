package com.ex7.entities;

import com.epam.commons.DataClass;
import com.ex7.enums.AccountEnum;

public class User extends DataClass {

    public String login;
    public String password;
    public String user;

    public User(AccountEnum accountEnum) {
        this.login = accountEnum.login;
        this.password = accountEnum.password;
        this.user = accountEnum.user;
    }
}
