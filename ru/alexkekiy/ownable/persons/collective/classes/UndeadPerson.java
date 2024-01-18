package ru.alexkekiy.ownable.persons.collective.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.interfaces.Movements;
import ru.alexkekiy.ownable.persons.abstracts.classes.AlivePerson;

public class UndeadPerson extends AlivePerson implements Movements {

    public UndeadPerson(String n, Sex s) {
        super(n, s, 0);
    }


}
