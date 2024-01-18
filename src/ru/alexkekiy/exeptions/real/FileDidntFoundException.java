package ru.alexkekiy.exeptions.real;

import ru.alexkekiy.exeptions.abstracts.Checked;

public class FileDidntFoundException extends Checked {
    FileDidntFoundException() {
        super();
    }
    FileDidntFoundException(String m) {
        super(m);
    }
}
