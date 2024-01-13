package ru.alexkekiy.enums;

public enum ItemSeize {
    BIG(5),
    MEDIUM(3),
    SMALL(1);
    private final int seize;

    public int getSeize() {
        return seize;
    }
    ItemSeize(int sz) {
        this.seize = sz;
    }


}
