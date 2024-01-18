package ru.alexkekiy.ownable.persons.real;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;

public class Jude extends AlivePerson {
    public Jude() {
        super("Джуд", Sex.MALE);
    }
    @Override
    public String inizialize(){
        return ": пожилой мужчина,сосед Кридов";
    }

}
