package ru.alexkekiy.interfaces;

import ru.alexkekiy.ownable.locations.abstracts.Loc;

public interface Movements {
    void run();

    void go();

    void goTo(Loc l);


}
