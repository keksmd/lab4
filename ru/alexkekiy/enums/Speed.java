package ru.alexkekiy.enums;

public enum Speed {
    SLOW(1),
    NORMAL(2),
    FAST(3);

    Speed(int i) {
        this.value = i;
    }

    private final int value;

    public int getValue() {
        return value;
    }
}
