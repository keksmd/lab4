package ru.alexkekiy.ownable.persons.abstracts;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.enums.Thoughts;
import ru.alexkekiy.enums.Time;
import ru.alexkekiy.exeptions.real.ResurrectLocationException;
import ru.alexkekiy.exeptions.real.ResurrectTimeException;
import ru.alexkekiy.interfaces.BrainActivity;
import ru.alexkekiy.interfaces.ItemActions;
import ru.alexkekiy.interfaces.Movements;
import ru.alexkekiy.interfaces.utilitare.InizializationCommand;
import ru.alexkekiy.items.Item;
import ru.alexkekiy.main.Main;
import ru.alexkekiy.ownable.locations.abstracts.Loc;
import ru.alexkekiy.ownable.persons.collective.Corpse;
import ru.alexkekiy.ownable.persons.collective.UndeadPerson;

import static ru.alexkekiy.main.Main.StoryTell.*;
import static ru.alexkekiy.utilites.Delay.delayP;

abstract public class AlivePerson extends Person implements Movements, ItemActions, BrainActivity,InizializationCommand {

    private int stamina;


    public AlivePerson(String n, Sex s) {
        super(n, s, 100, 80);
        this.stamina = 100;
    }
    protected AlivePerson(String n, Sex s, int hb) {
        super(n, s, 100, hb);
        this.stamina = 100;
    }

    public void resurrect(DeadPerson dead)  throws ResurrectLocationException, ResurrectTimeException{
        if (Main.StoryTell.getTime() == Time.EVENING | Main.StoryTell.getTime() == Time.NIGHT) {
            if (this.getLoc().equals(dead.getLoc())) {
                delayP(this);
                System.out.printf("%s воскрешает %s a %n",this.getName() , dead.getName());
                undeadActorList.put(dead.getName(), new UndeadPerson(dead.getName(), dead.getSex()));
                System.out.printf("%s : Ура, я снова <<жив>>!%n",dead.getName());

                deadActorList.remove(dead.getName());

            } else{
                    throw new ResurrectLocationException();
            }
        } else {
                throw new ResurrectTimeException(Main.StoryTell.getTime());
        }

    }
    public String inizialize(){
        return "";
    }
    public Corpse kill(AlivePerson p) {
        System.out.printf("%s убивает %s %n",this.getName(),p.getName());
        Corpse d = new Corpse(p.getName(), p.getSex(), p.getLoc());
        deadActorList.put(d.getName(),d);
        aliveActorList.remove(p.getName());
        return d;

    }



    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            AlivePerson f = (AlivePerson) o;
            return this.stamina == f.stamina;
        }
       return false;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina <= 100 & 0 <= stamina) {
            this.stamina = stamina;
        }
    }

    public void run() {
        if (this.getStamina() > 20) {
            delayP(this);
            System.out.printf("%s бежит %n",this.getName());
            this.setHeartbeats(Math.toIntExact(Math.round(this.getHeartbeats() * 1.2)));
            this.setStamina(this.getStamina() - 20);

        } else {
            System.out.printf("%s слишком устал чтобы бежать %n",this.getName());
        }
    }

    public void go() {
        if (this.getStamina() > 5) {
            delayP(this);
            System.out.println(this.getName() + " идет ");
            if (this.getHeartbeats() > 80) {
                this.setHeartbeats(80);
            }
            this.setStamina(this.getStamina() - 5);
        } else {
            System.out.printf("%s слишком устал чтобы идти %n",this.getName());
        }
    }

    public void goTo(Loc l) {
        if (this.getStamina() > 5) {
            this.go();
            l.enter(this);
        } else {
            System.out.printf("%s слишком устал чтобы идти %n",this.getName());
        }
    }


    public void think(Thoughts t) {
        delayP(this);
        System.out.printf("%s думаает: %s %n",this.getName(),t.getThough());
        if(!t.isPositive()){
            this.setStamina(Math.max(this.getStamina()-3,0));
        }else{
            this.setStamina(Math.min(this.getStamina()+3,100));
        }
    }

    public void remember(Person p, Thoughts t) {
        delayP(this);
        System.out.printf("%s вспомианет слова %sа: %s %n" ,this.getName(),p.getName(),t.getThough());
        if(!t.isPositive()){
            this.setStamina(Math.max(this.getStamina()-5,0));
        }
    }

    public void say(String s) {
        System.out.printf("%s: <<%s>>%n",this.getName(),s);
    }

    public void take(Item i) {
        if (i.getOwner().equals(this.getLoc())) {
            i.setOwner(this);
        } else {
            System.out.println("Взять можно только объект,который находится с вами в одной локации");
        }
    }

    public void put(Item i) {
        if (i.getOwner().equals(this)) {
            i.setOwner(this.getLoc());
        } else {
            System.out.printf("%s не принадлежит вам",i.getName());
        }

    }
}

