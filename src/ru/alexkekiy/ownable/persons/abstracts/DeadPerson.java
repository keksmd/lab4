package ru.alexkekiy.ownable.persons.abstracts;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.locations.abstracts.Loc;

abstract public class DeadPerson extends Person {
    @Override
    public String inizialize() {
        return "";
    }

    public DeadPerson(String n, Sex s) {
        super(n, s, 0, 0);
    }

    public DeadPerson(String n, Sex s, Loc l) {
        super(n, s, 0, 0, l);
    }


}
