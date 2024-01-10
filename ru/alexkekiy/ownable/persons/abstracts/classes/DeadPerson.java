package ru.alexkekiy.ownable.persons.abstracts.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;

abstract public class DeadPerson extends Person {

    public DeadPerson(String n, Sex s) {
        super(n, s, 0, 0);
    }

    public DeadPerson(String n, Sex s, Loc l) {
        super(n, s, 0, 0, l);
    }


}
