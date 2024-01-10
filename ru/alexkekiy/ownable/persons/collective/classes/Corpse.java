package ru.alexkekiy.ownable.persons.collective.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;
import ru.alexkekiy.ownable.persons.abstracts.classes.DeadPerson;

public class Corpse extends DeadPerson {

    public Corpse(String n, Sex s) {
        super(n, s);
    }

    public Corpse(String n, Sex s, Loc l) {
        super(n, s, l);
    }
}
