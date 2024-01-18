package ru.alexkekiy.ownable.locations.abstracts;

import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;
import ru.alexkekiy.utilites.Delay;

abstract public class LocThrough extends Loc {

    public LocThrough(String n) {
        super(n);
    }

    @Override
    public void enter(AlivePerson p) {
        Delay.delayP(p);
        System.out.printf("%s идет по локации %s%n",p.getName() , this.getName());
        p.setLoc(this);
    }
}
