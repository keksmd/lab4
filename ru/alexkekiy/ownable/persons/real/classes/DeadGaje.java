package ru.alexkekiy.ownable.persons.real.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;
import ru.alexkekiy.ownable.persons.abstracts.classes.DeadPerson;

public class DeadGaje extends DeadPerson {

    public DeadGaje(String n, Sex s) {
        super(n, s);
    }

    public DeadGaje(String n, Sex s, Loc l) {
        super(n, s, l);
    }


}
