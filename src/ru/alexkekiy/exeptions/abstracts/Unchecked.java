package ru.alexkekiy.exeptions.abstracts;

public abstract class Unchecked extends RuntimeException {
    public Unchecked() {
        super("Обнаружено проверяемое исключение: \n");
    }

    public Unchecked(String m) {
        super("Обнаружено непроверяемое исключение: \n" + m);
    }
}
