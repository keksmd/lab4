package ru.alexkekiy.exeptions;

public class FileException extends Checked {
    FileException() {
        super();
    }
    FileException(String m) {
        super(m);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
