package ru.alexkekiy.exeptions.real;

import ru.alexkekiy.exeptions.abstracts.Unchecked;

public class ResurrectLocationException extends Unchecked {
    public ResurrectLocationException() {
        super("При поптыке воскресить возникла ошибка: чтобы воскресить нужно находиться в одной локации с объектом воскрешения");
    }

    public ResurrectLocationException(String message) {
        super(message);
    }
}
