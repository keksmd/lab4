package ru.alexkekiy.enums;

public enum Speed {
    SLOW(1),
    NORMAL(2),
    FAST(3);

    private final int value;
    Speed(int i) {
        this.value = i;
    }



    public int getValue() {
        return value;
    }
}
