package ownable.persons.collective.classes;

import enums.Sex;
import ownable.locations.abstracts.classes.Loc;
import ownable.persons.abstracts.classes.DeadPerson;

public class Corpse extends DeadPerson {

    public Corpse(String n, Sex s) {
        super(n, s);
    }

    public Corpse(String n, Sex s, Loc l) {
        super(n, s, l);
    }
}
