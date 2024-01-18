package ru.alexkekiy.ownable.persons.real;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;

public class Luis extends AlivePerson {
    public Luis() {
        super("Луис", Sex.MALE);
    }
    @Override
    public String inizialize(){
        return ": Мужчина,36 лет,глава семейства Кридов, отец Гэджа";
    }
}
