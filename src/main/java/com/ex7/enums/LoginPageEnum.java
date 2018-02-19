package com.ex7.enums;

public enum LoginPageEnum {
    URL("https://jdi-framework.github.io/tests/"),
    LOGIN("epam"),
    PASSWORD("1234"),
    TITLE("Index Page"),
    USERNAME("PITER CHAILOVSKII");

    public final String text;

    LoginPageEnum(String text) {
        this.text = text;
    }
}
