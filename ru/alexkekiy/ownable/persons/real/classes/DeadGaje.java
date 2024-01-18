package ru.alexkekiy.ownable.persons.real.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.persons.abstracts.classes.DeadPerson;

import static ru.alexkekiy.main.Main.StoryTell.locList;

public class DeadGaje extends DeadPerson {


    public DeadGaje() {
        super("Гэдж", Sex.MALE,locList.get("могила Гэджа"));
    }


}
