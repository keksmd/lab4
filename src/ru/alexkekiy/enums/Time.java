package ru.alexkekiy.enums;

public enum Time {
    MORNING("утро"),
    DAY("день"),
    EVENING("вечер"),
    NIGHT("ночь");
    private final String value;

    Time(String v) {
        this.value = v;

    }

    public String getValue() {
        return value;
    }
}
