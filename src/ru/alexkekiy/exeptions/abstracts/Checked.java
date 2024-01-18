package ru.alexkekiy.exeptions.abstracts;

public abstract class Checked extends Exception {
    public Checked() {
        super("Обнаружено проверяемое исключение: \n");
    }

    public Checked(String m) {
        super("Обнаружено проверяемое исключение: \n" + m);
    }
}
