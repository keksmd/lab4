package ru.alexkekiy.exeptions;

public abstract class Unchecked extends RuntimeException {
    Unchecked() {
        super();
    }

    Unchecked(String m) {
        super(m);
    }
}
