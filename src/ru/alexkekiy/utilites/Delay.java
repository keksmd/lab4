package ru.alexkekiy.utilites;

import ru.alexkekiy.enums.Speed;
import ru.alexkekiy.ownable.persons.abstracts.AlivePerson;

import static java.lang.Thread.sleep;

public class Delay {
    private  final static int FIRST_STAMINA_DELIMITER = 33;
    private  final static int SECOND_STAMINA_DELIMITER = 66;
    public static void delayP(AlivePerson p) {
        if (p.getStamina() > FIRST_STAMINA_DELIMITER) {
            if (p.getStamina() > SECOND_STAMINA_DELIMITER) {
                p.setSpeed(Speed.FAST);
            } else {
                p.setSpeed(Speed.NORMAL);
            }
        } else {
            p.setSpeed(Speed.SLOW);
        }
        try {
            sleep(2000 / p.getSpeed().getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delay() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
