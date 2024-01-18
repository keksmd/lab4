package ru.alexkekiy.exeptions;

public abstract class Checked extends Exception {
    public Checked() {
        super();
    }

    public Checked(String m) {
        super(m);
    }
}
