package ru.alexkekiy.ownable.persons.collective;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.interfaces.Movements;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;

public class UndeadPerson extends AlivePerson implements Movements {

    public UndeadPerson(String n, Sex s) {
        super(n, s, 0);
    }
    public UndeadPerson(String n, Sex s,int hb) {
        super(n, s, hb);
    }


}
