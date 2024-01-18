package ru.alexkekiy.exeptions;

public class FileDidntFoundException extends Checked {
    FileDidntFoundException() {
        super();
    }
    FileDidntFoundException(String m) {
        super(m);
    }
}
