package com.ex8.entities;

import com.epam.commons.DataClass;
import com.ex8.enums.AccountEnum;

// TODO Read IDEA warning
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
