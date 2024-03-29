package ru.alexkekiy.ownable.locations.abstracts.classes;

import ru.alexkekiy.ownable.persons.abstracts.classes.AlivePerson;
import ru.alexkekiy.utilites.Delay;

abstract public class LocThrough extends Loc {

    public LocThrough(String n) {
        super(n);
    }

    @Override
    public void enter(AlivePerson p) {
        Delay.delayP(p);
        System.out.println(p.getName() + " идет по локации " + this.getName());
        p.setLoc(this);
    }
}
