package utilites;
import enums.Sex;
import main.*;
import ownable.persons.collective.classes.UndeadPerson;

public class CreatePerson {
    public static void createUndead(String name, Sex s){
        Main.StoryTell.undeadActorList.put(name,new UndeadPerson(name,s));
    }
}
