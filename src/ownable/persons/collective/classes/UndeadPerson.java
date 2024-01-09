package ownable.persons.collective.classes;

import enums.*;
import interfaces.Movements;
import ownable.persons.abstracts.classes.AlivePerson;

public class UndeadPerson extends AlivePerson implements Movements {

    public UndeadPerson(String n, Sex s){
        super(n,s,0);
    }




}
