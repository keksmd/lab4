package ru.alexkekiy.ownable.persons.abstracts;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.enums.Speed;
import ru.alexkekiy.interfaces.utilitare.InizializationCommand;
import ru.alexkekiy.ownable.Ownable;
import ru.alexkekiy.ownable.locations.abstracts.Loc;
import ru.alexkekiy.ownable.locations.real.Out;

abstract public class Person extends Ownable implements InizializationCommand {
    private int hp;
    private Sex sex;
    private Speed speed;
    private int heartbeats;
    private Loc loc;


    public Person(String name) {
        super(name);
    }
    public Speed getSpeed() {
        return speed;
    }


    public Person(String n, Sex s, int hp, int hb) {
        super(n);
        this.sex = s;
        this.hp = hp;
        this.loc = new Out();
        this.speed = Speed.NORMAL;
        this.heartbeats = hb;
    }
    public Person(String n, Sex s, int hp, int hb, Loc l) {
        super(n);
        this.sex = s;
        this.hp = hp;
        this.loc = l;
        this.speed = Speed.NORMAL;
        this.heartbeats = hb;
    }
    public void setLoc(Loc l) {
        this.loc = l;
    }
    public Loc getLoc() {
        return this.loc;
    }
    public void setHeartbeats(int i) {
        if (this.getHeartbeats() < i) {
            System.out.printf("Сердце %s а забилось быстрее: %d%n",this.getName(),i);
        } else if ((this.getHeartbeats() > i)) {
            System.out.printf("Сердце %sа замедлилось до %d%n",this.getName(),i);
        }
        this.heartbeats = i;
    }
    public Sex getSex() {
        return this.sex;
    }
    public int getHeartbeats() {
        return this.heartbeats;
    }
    public void setSpeed(Speed s) {
        this.speed = s;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            Person f = (Person) o;
            return this.hp == f.hp & this.sex == f.sex & this.heartbeats == f.heartbeats & this.speed == f.speed & this.loc == f.loc;
        } else return false;
    }
}
