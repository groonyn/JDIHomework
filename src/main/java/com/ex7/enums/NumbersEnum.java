package com.ex7.enums;

public enum NumbersEnum {
    TWO(2),
    FOUR(4),
    SIX(6),
    EIGHT(8),
    ONE(1),
    THREE(3),
    FIVE(5),
    SEVEN(7);

    public final Integer number;

    NumbersEnum(Integer number) {
        this.number = number;
    }
}
