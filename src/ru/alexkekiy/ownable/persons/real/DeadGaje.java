package ru.alexkekiy.ownable.persons.real;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.ownable.persons.abstracts.DeadPerson;

import static ru.alexkekiy.main.Main.StoryTell.locList;

public class DeadGaje extends DeadPerson {


    public DeadGaje() {
        super("Гэдж", Sex.MALE,locList.get("могила Гэджа"));
    }
    @Override
    public String inizialize(){
        return ": Мужчина,36 лет,глава семейства Кридов, отец Гэджа ";
    }

}
