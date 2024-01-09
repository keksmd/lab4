package ownable.persons.real.classes;

import ownable.locations.abstracts.classes.Loc;
import enums.Sex;
import ownable.persons.abstracts.classes.DeadPerson;

public class DeadGaje extends DeadPerson {

    public DeadGaje(String n, Sex s) {
        super(n, s);
    }
    public DeadGaje(String n, Sex s, Loc l) {
        super(n, s,l);
    }




}
