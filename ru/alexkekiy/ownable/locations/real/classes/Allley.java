package ru.alexkekiy.ownable.locations.real.classes;

import ru.alexkekiy.enums.Sounds;
import ru.alexkekiy.enums.Speed;
import ru.alexkekiy.enums.Thoughts;
import ru.alexkekiy.ownable.locations.abstracts.classes.LocThrough;
import ru.alexkekiy.ownable.persons.abstracts.classes.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.classes.Person;

import static ru.alexkekiy.utilites.Randomizer.chance;

public class Allley extends LocThrough {

    public Allley(String n) {
        super(n);
    }

    @Override
    public void enter(AlivePerson p) {
        super.enter(p);
        if (chance(0.5)) {
            System.out.println(Sounds.SHURSH.getSound() + " Шуршат деревья");
        }
        if (p.getName().equals("Луис")) {
            p.think(Thoughts.LUIS1);
            p.setHeartbeats(Math.toIntExact(Math.round(p.getHeartbeats() * 1.2)));
            p.setSpeed(Speed.FAST);
        }
    }

    @Override
    public boolean getUsl(Person p) {
        if (p.getLoc().getName().equals("тропинка")) {
            return super.getUsl(p);
        } else {
            return false;
        }

    }
}

