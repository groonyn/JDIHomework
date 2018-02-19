package com.ex7.enums;

public enum SaladEnum {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    SALAD("Salad"),
    ONION("Onion");

    public final String text;

    SaladEnum(String text) {
        this.text = text;
    }
}

