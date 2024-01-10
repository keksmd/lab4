package ru.alexkekiy.interfaces;

import ru.alexkekiy.enums.Thoughts;
import ru.alexkekiy.ownable.persons.abstracts.classes.Person;

public interface BrainActivity {
    void say(String s);

    void think(Thoughts t);

    void remember(Person p, Thoughts t);
}
