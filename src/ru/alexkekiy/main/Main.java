package ru.alexkekiy.main;



import ru.alexkekiy.enums.Time;

import ru.alexkekiy.exeptions.real.ResurrectLocationException;
import ru.alexkekiy.exeptions.real.ResurrectTimeException;
import ru.alexkekiy.ownable.locations.abstracts.Loc;
import ru.alexkekiy.ownable.locations.real.Allley;
import ru.alexkekiy.ownable.locations.real.Grave;
import ru.alexkekiy.ownable.locations.real.GraveTrail;
import ru.alexkekiy.ownable.locations.real.Tombs;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;
import ru.alexkekiy.ownable.persons.abstracts.DeadPerson;
import ru.alexkekiy.ownable.persons.collective.UndeadPerson;
import ru.alexkekiy.ownable.persons.real.DeadGaje;
import ru.alexkekiy.ownable.persons.real.Jude;
import ru.alexkekiy.ownable.persons.real.Luis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StoryTell.createActorsNLoc();
        StoryTell.setStory();
        StoryTell.storyGo();
    }

    public final static class StoryTell {
        static final String luisName = "Луис";
        static final String judeName = "Джуд";
        static final String gajeName = "Гэдж";
        final static String graveName = "Кладбище";
        final static String graveGajeName = "могила Гэджа";
        final static String alley = "Аллея";
        final static String tomb = "могила";
        final static String graveTrail = "Тропинка на кладбище";
        private StoryTell(){
        }
        private static Time time;
        public static final Map<String, AlivePerson> aliveActorList = new HashMap<>();
        public static final Map<String, DeadPerson> deadActorList = new HashMap<>();
        public static final Map<String, UndeadPerson> undeadActorList = new HashMap<>();
        public static final Map<String, Loc> locList = new HashMap<>();

        public static void setTime(Time time) {
            StoryTell.time = time;
        }

        public static void startTime() {
            System.out.println("Перед началом выберите, в какое время суток вы хотите,чтобы происходила история. Введите утро ,день, вечер или ночь");
            String line = new Scanner(System.in).nextLine().toLowerCase();
            boolean flag = false;
            for(Time t:Time.values()){
                if(t.getValue().equals(line)){
                    StoryTell.setTime(t);
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("Вы ввели неправильное время, попробуйте еще раз");
                startTime();
            }
        }

        public static Time getTime() {
            return time;
        }

        public static void createActorsNLoc() {
            locList.put(graveName, new Grave());
            locList.put(graveGajeName, new Tombs(graveGajeName));
            locList.put(alley, new Allley(alley));
            locList.put(tomb, new Tombs(tomb));
            locList.put(graveTrail, new GraveTrail(graveTrail));

            aliveActorList.put(luisName, new Luis());
            aliveActorList.put(judeName, new Jude());
            deadActorList.put(gajeName, new DeadGaje());
        }

        interface Declaring {
            String declare();
        }

        public static void declareActors(Map<String, AlivePerson> map) {
            System.out.println("          Действующие лица: ");
            for (AlivePerson man : map.values()) {
                System.out.printf("%s%s %n",man.getName(), man.inizialize());
            }
        }

        public static void declareDeadActors(Map<String, DeadPerson> map) {
            System.out.println("          Не совсем действующие лица: ");
            for (String name : map.keySet()) {
                System.out.printf("  %s",name);

                class Declation implements Declaring {
                    private final String name;

                    public Declation(String name) {
                        this.name = name;
                    }
                    @Override
                    public String declare() {
                        String opis = "";
                        if (name.equals(gajeName)) {
                            opis += ": Мальчик, сын Луиса, на данный момент мертв";
                        } else {
                            opis += "";
                        }
                        return opis;
                    }
                }
                Declaring a = new Declation(name);
                System.out.println(a.declare());
            }
        }
        public static void storyGo() {
            locList.get(graveName).enter(aliveActorList.get(luisName));
            aliveActorList.get(luisName).run();
            aliveActorList.get(luisName).goTo(locList.get(graveTrail));
            aliveActorList.get(luisName).goTo(locList.get(alley));
            aliveActorList.get(luisName).goTo(locList.get(graveGajeName));
            try{
            aliveActorList.get(luisName).resurrect(deadActorList.get(gajeName));
            } catch (ResurrectTimeException | ResurrectLocationException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void setStory() {
            startTime();
            declareActors(aliveActorList);
            declareDeadActors(deadActorList);
            System.out.println("------Начало------");
            System.out.printf("за окном %s%n",time.getValue());
        }

    }

}