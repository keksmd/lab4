package ru.alexkekiy.ownable.locations.abstracts.classes;

import ru.alexkekiy.ownable.Ownable;
import ru.alexkekiy.ownable.persons.abstracts.classes.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.classes.Person;
import ru.alexkekiy.utilites.Delay;

abstract public class Loc extends Ownable {


    public Loc(String n) {
        super(n);
    }

    public boolean getUslovie(Person p) {
        boolean uslovie = true;
        return uslovie;
    }
    public void enter(AlivePerson p) {
        if (this.getUslovie(p)) {
            Delay.delayP(p);
            System.out.println(p.getName() + " входит в локацию " + this.getName());
            p.setLoc(this);
        } else {
            System.out.println("Невозможно войти в локацию");
        }


    }
}
