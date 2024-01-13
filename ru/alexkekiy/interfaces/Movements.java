package ru.alexkekiy.interfaces;

import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;

public interface Movements {
    void run();

    void go();

    void goTo(Loc l);


}
