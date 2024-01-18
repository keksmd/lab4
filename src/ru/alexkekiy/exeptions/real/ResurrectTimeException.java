package ru.alexkekiy.exeptions.real;

import ru.alexkekiy.enums.Time;
import ru.alexkekiy.exeptions.abstracts.Unchecked;

public class ResurrectTimeException extends Unchecked {
    public ResurrectTimeException(Time t) {
        super("При поытке воскресить возникла ошибка: воскрешение возможно только ночью или вечером. Сейчас:" + t.getValue());
    }

    public ResurrectTimeException() {
        super();
    }

}
