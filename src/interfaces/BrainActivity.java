package interfaces;

import enums.Thoughts;
import ownable.persons.abstracts.classes.Person;

public interface BrainActivity {
    void say(String s);
    void think(Thoughts t);
    void remember(Person p, Thoughts t);
}
