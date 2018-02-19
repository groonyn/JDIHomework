package com.ex7.enums;

public enum AccountEnum {
    PITER_CHAILOVSKI("epam", "1234", "PITER CHAILOVSKI");

    public final String login;
    public final String password;
    public final String user;

    AccountEnum(String login, String password, String user) {
        this.login = login;
        this.password = password;
        this.user = user;
    }

}
