package ru.alexkekiy.ownable.locations.abstracts;

import ru.alexkekiy.ownable.Ownable;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.Person;
import ru.alexkekiy.utilites.Delay;

abstract public class Loc extends Ownable {


    public Loc(String n) {
        super(n);
    }

    public boolean getUslovie(Person p) {
        return true;
    }
    public void enter(AlivePerson p) {
        if (this.getUslovie(p)) {
            Delay.delayP(p);
            System.out.printf("%s входит в локацию %s%n",p.getName(),this.getName());
            p.setLoc(this);
        } else {
            System.out.println("Невозможно войти в локацию");
        }


    }
}
