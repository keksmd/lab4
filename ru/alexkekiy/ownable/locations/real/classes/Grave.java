package ru.alexkekiy.ownable.locations.real.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.enums.Sounds;
import ru.alexkekiy.enums.Thoughts;
import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;
import ru.alexkekiy.ownable.persons.abstracts.classes.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.classes.Person;
import ru.alexkekiy.ownable.persons.real.classes.Jude;

import static ru.alexkekiy.utilites.Delay.delay;

public class Grave extends Loc {

    @Override
    public boolean getUsl(Person p) {
        if (Gates.getOpened()) {
            return super.getUsl(p);
        } else {
            Gates.open();
            return super.getUsl(p);
        }
    }

    @Override
    public void enter(AlivePerson p) {
        super.enter(p);
        Grave.Gates.close();
        if (p.getName().equals("Луис")) {
            p.think(Thoughts.LUIS3);
            p.remember(new Jude("Джуд", Sex.MALE), Thoughts.LUIS2);
        }
    }

    public Grave() {
        super("кладбище");
    }

    public static class Gates extends Loc {
        public static boolean opened = false;

        public static void open() {
            delay();
            opened = true;
            System.out.println(Sounds.SKRIP.getSound() + "Ворота открываются");
        }

        public static void close() {
            delay();
            opened = false;
            System.out.println(Sounds.SHELK.getSound() + "Ворота закрываются");
        }

        static public boolean getOpened() {
            return opened;
        }


        public Gates(String n) {
            super(n);
        }
    }
}

