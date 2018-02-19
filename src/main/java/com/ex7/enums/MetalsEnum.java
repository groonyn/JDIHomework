package com.ex7.enums;

public enum MetalsEnum {
    METAL("Metal"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public final String text;

    MetalsEnum(String text) {
        this.text = text;
    }
}
