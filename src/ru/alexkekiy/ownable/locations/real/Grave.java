package ru.alexkekiy.ownable.locations.real;

import ru.alexkekiy.enums.Sounds;
import ru.alexkekiy.enums.Thoughts;
import ru.alexkekiy.ownable.locations.abstracts.Loc;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.Person;

import static ru.alexkekiy.main.Main.StoryTell.aliveActorList;
import static ru.alexkekiy.utilites.Delay.delay;

public class Grave extends Loc {

    @Override
    public boolean getUslovie(Person p) {
        if (!Gates.getOpened()) {
            Gates.open();
        }
        return super.getUslovie(p);
    }

    @Override
    public void enter(AlivePerson p) {
        super.enter(p);
        Grave.Gates.close();
        if (p.getName().equals("Луис")) {
            p.think(Thoughts.LUIS3);
            p.remember(aliveActorList.get("Джуд"), Thoughts.LUIS2);
        }
    }

    public Grave() {
        super("кладбище");
    }

    public static class Gates extends Loc {
        public static boolean opened = false;
        public Gates(String n) {
            super(n);
        }
        public static void open() {
            delay();
            opened = true;
            System.out.printf("%s Ворота открываются%n  ",Sounds.SKRIP.getSound() );
        }

        public static void close() {
            delay();
            opened = false;
            System.out.printf("%s Ворота закрываются%n",Sounds.SHELK.getSound() );
        }

        static public boolean getOpened() {
            return opened;
        }



    }
}

