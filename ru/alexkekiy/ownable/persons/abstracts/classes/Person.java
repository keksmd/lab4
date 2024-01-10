package ru.alexkekiy.ownable.persons.abstracts.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.enums.Speed;
import ru.alexkekiy.ownable.Ownable;
import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;
import ru.alexkekiy.ownable.locations.real.classes.Out;

abstract public class Person extends Ownable {
    private int hp;
    private Sex sex;
    private Speed speed;

    public Speed getSpeed() {
        return speed;
    }

    private int heartbeats;

    public Person(String name) {
        super(name);
    }

    public void setHeartbeats(int i) {
        if (this.getHeartbeats() < i) {
            System.out.println("Сердце " + this.getName() + "а забилось быстрее: " + i);
        } else if ((this.getHeartbeats() > i)) {
            System.out.println("Сердце " + this.getName() + "а замедлилось до " + i);
        }
        this.heartbeats = i;
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

    private Loc loc;

    public void setLoc(Loc l) {
        this.loc = l;
    }

    public Loc getLoc() {
        return this.loc;
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
