package ru.alexkekiy.ownable.locations.real;

import ru.alexkekiy.enums.Sounds;
import ru.alexkekiy.enums.Speed;
import ru.alexkekiy.enums.Thoughts;
import ru.alexkekiy.ownable.locations.abstracts.LocThrough;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.Person;

import static ru.alexkekiy.utilites.Randomizer.chance;

public class Allley extends LocThrough {

    public Allley(String n) {
        super(n);
    }

    @Override
    public void enter(AlivePerson p) {
        super.enter(p);
        if (chance(0.5)) {
            System.out.printf("%s Шуршат деревья%n",Sounds.SHURSH.getSound() );
        }
        if (p.getName().equals("Луис")) {
            p.think(Thoughts.LUIS1);
            p.setHeartbeats(Math.toIntExact(Math.round(p.getHeartbeats() * 1.2)));
            p.setSpeed(Speed.FAST);
        }
    }

    @Override
    public boolean getUslovie(Person p) {
        if (p.getLoc().getName().equals("тропинка")) {
            return super.getUslovie(p);
        } else {
            return false;
        }

    }
}

