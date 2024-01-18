package ru.alexkekiy.exeptions.real;

import ru.alexkekiy.exeptions.abstracts.Unchecked;

public class InputException extends Unchecked {
    public InputException(String s){
        super(String.format("Введены неверные данные\n %s",s));
    }
}
