package ru.alexkekiy.main;


import ru.alexkekiy.enums.ItemSeize;
import ru.alexkekiy.enums.Time;
import ru.alexkekiy.items.Food;
import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;
import ru.alexkekiy.ownable.locations.real.classes.Allley;
import ru.alexkekiy.ownable.locations.real.classes.Grave;
import ru.alexkekiy.ownable.locations.real.classes.GraveTrail;
import ru.alexkekiy.ownable.locations.real.classes.Tombs;
import ru.alexkekiy.ownable.persons.abstracts.classes.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.classes.DeadPerson;
import ru.alexkekiy.ownable.persons.collective.classes.UndeadPerson;
import ru.alexkekiy.ownable.persons.real.classes.DeadGaje;
import ru.alexkekiy.ownable.persons.real.classes.Jude;
import ru.alexkekiy.ownable.persons.real.classes.Luis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        StoryTell.createActorsNLoc();
        StoryTell.setStory();
        StoryTell.storyGo();
    }

    public abstract static class StoryTell {
        private static Time time;
        public static final Map<String, AlivePerson> aliveActorList = new HashMap<>();
        public static final Map<String, DeadPerson> deadActorList = new HashMap<>();
        public static final Map<String, UndeadPerson> undeadActorList = new HashMap<>();
        public static final Map<String, Loc> locList = new HashMap<>();

        public static void setTime(Time time) {
            StoryTell.time = time;
        }

        public static void startTime() {
            System.out.println("Перед началом выберите, в какое время сутокen вы хотите,чтобы происходила история. Введите  'Утро' ,'День' , 'Вечер' или 'Ночь' ");
            String line = new Scanner(System.in).nextLine();
            boolean flag = false;
            for(Time t:Time.values()){
                if(t.getValue().equals(line)){
                    StoryTell.setTime(t);
                    flag = true;
                }
            }
            if(!flag){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Вы ввели неправильное время, попробуйте еще раз");
                    startTime();
                }
            }

        }

        public static Time getTime() {
            return time;
        }

        public static void createActorsNLoc() {
            locList.put("Кладбище", new Grave());
            locList.put("могила Гэджа", new Tombs("могила Гэджа"));
            locList.put("Аллея", new Allley("Аллея"));
            locList.put("могила", new Tombs("могила"));
            locList.put("Тропинка на кладбище", new GraveTrail("Тропинка на кладбище"));

            aliveActorList.put("Луис", new Luis());
            aliveActorList.put("Джуд", new Jude());
            deadActorList.put("Гэдж", new DeadGaje());
        }

        interface Declaring {
            String declare();
        }

        public static void declareActors(Map<String, AlivePerson> map) {
            System.out.println("          Действующие лица: ");
            for (String name : map.keySet()) {
                System.out.print("  " + name);
                Declaring a = () -> {
                    String opis = "";
                    switch (name) {
                        case "Луис" -> System.out.println(": Мужчина,36 лет,глава семейства Кридов, отец Гэджа ");
                        case "Джуд" -> System.out.println(": пожилой мужчина,сосед Кридов ");
                        case "Гэдж" -> System.out.println(":Мальчик, сын Луиса, на данный момент мертв ");
                        default -> opis = "\n";
                    }
                    return opis;
                };
                a.declare();
            }
        }

        public static void declareDeadActors(Map<String, DeadPerson> map) {
            System.out.println("          Не совсем действующие лица: ");
            for (String name : map.keySet()) {
                System.out.print("  " + name);

                class Declation implements Declaring {
                    private final String name;

                    public Declation(String name) {
                        this.name = name;
                    }
                    @Override
                    public String declare() {
                        String opis;
                        switch (name) {
                            case "Луис" -> {
                                return ": Мужчина, 36 лет, глава семейства Кридов, отец Гэджа";
                            }
                            case "Джуд" -> {
                                return ": пожилой мужчина, сосед Кридов";
                            }
                            case "Гэдж" -> {
                                return ": Мальчик, сын Луиса, на данный момент мертв";
                            }
                            default -> opis = "\n";
                        }
                        return opis;
                    }
                }
                Declaring a = new Declation(name);
                System.out.println(a.declare());
            }
        }

        static void storyGo() {

            Food apple = new Food(50, ItemSeize.SMALL, "яблоко");
            locList.get("Кладбище").enter(aliveActorList.get("Луис"));
            aliveActorList.get("Луис").run();
            aliveActorList.get("Луис").goTo(locList.get("Тропинка на кладбище"));
            aliveActorList.get("Луис").goTo(locList.get("Аллея"));
            aliveActorList.get("Луис").goTo(locList.get("могила Гэджа"));
            aliveActorList.get("Луис").resurrect(deadActorList.get("Гэдж"));

        }

        static void setStory() {
            startTime();
            declareActors(aliveActorList);
            declareDeadActors(deadActorList);
            System.out.println("------Начало------");
            System.out.println("за окном " + time.getValue());
        }

    }

}