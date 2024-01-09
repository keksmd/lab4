package utilites;

import enums.Speed;
import ownable.persons.abstracts.classes.AlivePerson;

import static java.lang.Thread.sleep;

public class Delay {
    public static void delayP(AlivePerson p) {
        if(p.getStamina()>33){
            if(p.getStamina()>66){
                p.setSpeed(Speed.FAST);
            }else{
                p.setSpeed(Speed.NORMAL);
            }
        }else{
            p.setSpeed(Speed.SLOW);
        }
        try {
            sleep(2000 / p.getSpeed().getValue());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
