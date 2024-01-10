package ru.alexkekiy.ownable.persons.abstracts.classes;

import ru.alexkekiy.enums.Sex;
import ru.alexkekiy.enums.Thoughts;
import ru.alexkekiy.enums.Time;
import ru.alexkekiy.exeptions.ResurrectLocationException;
import ru.alexkekiy.exeptions.ResurrectTimeException;
import ru.alexkekiy.interfaces.BrainActivity;
import ru.alexkekiy.interfaces.ItemActions;
import ru.alexkekiy.interfaces.Movements;
import ru.alexkekiy.items.Food;
import ru.alexkekiy.items.Item;
import ru.alexkekiy.main.Main;
import ru.alexkekiy.ownable.locations.abstracts.classes.Loc;
import ru.alexkekiy.ownable.persons.collective.classes.Corpse;
import ru.alexkekiy.ownable.persons.collective.classes.UndeadPerson;

import static ru.alexkekiy.main.Main.StoryTell.undeadActorList;
import static ru.alexkekiy.utilites.Delay.delayP;

abstract public class AlivePerson extends Person implements Movements, ItemActions, BrainActivity {

    public AlivePerson(String n, Sex s) {
        super(n, s, 100, 80);
        this.stamina = 100;
    }

    public AlivePerson(String n) {
        super(n);
        this.stamina = 100;
    }

    protected AlivePerson(String n, Sex s, int hb) {
        super(n, s, 100, hb);
        this.stamina = 100;
    }

    public void resurrect(DeadPerson dead) {
        if (Main.StoryTell.getTime() == Time.EVENING | Main.StoryTell.getTime() == Time.NIGHT) {
            if (this.getLoc().equals(dead.getLoc())) {
                delayP(this);
                System.out.println(this.getName() + " воскрешает " + dead.getName() + "а");
                undeadActorList.put(dead.getName(), new UndeadPerson(dead.getName(), dead.getSex()));
                System.out.println(undeadActorList.get(dead.getName()).getName() + ": Ура, я снова <<жив>>!");
                dead = null;
            } else {
                try {
                    throw new ResurrectLocationException();
                } catch (ResurrectLocationException e) {
                    System.out.println(e.getMessage());
                }

            }
        } else {
            try {
                throw new ResurrectTimeException(Main.StoryTell.getTime());
            } catch (ResurrectTimeException e) {
                System.out.println(e.getMessage());
            }


        }

    }

    public Corpse kill(AlivePerson p) {
        System.out.println(this.getName() + " убивает " + p.getName());
        Corpse d = new Corpse(p.getName(), p.getSex(), p.getLoc());
        p = null;
        return d;

    }

    private int stamina;

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            AlivePerson f = (AlivePerson) o;
            return this.stamina == f.stamina;
        } else return false;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina <= 100 & 0 <= stamina) {
            this.stamina = stamina;
        }
    }

    public void eat(Food f) {
        if (!f.getOwner().equals(this)) {
            System.out.println("Чтобы съесть еду она должна находиться в вашем инвернтаре");
        } else {
            if (this.stamina + f.getCalories() > 100) {
                this.stamina = 100;
            } else {
                this.stamina += f.getCalories();
            }
            System.out.println(this.getName() + " съел " + f.getName() + " и восстановил " + f.getCalories() + " стамины,теперь: " + this.getStamina());

            f = null;
        }
    }

    public void run() {
        if (this.getStamina() > 20) {
            delayP(this);
            System.out.println(this.getName() + " бежит ");
            this.setHeartbeats(Math.toIntExact(Math.round(this.getHeartbeats() * 1.2)));
            this.setStamina(this.getStamina() - 20);

        } else {
            System.out.println(this.getName() + " слишком устал чтобы бежать");
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
            System.out.println(this.getName() + " слишком устал чтобы идти");
        }
    }

    public void goTo(Loc l) {
        if (this.getStamina() > 5) {
            this.go();
            l.enter(this);
        } else {
            System.out.println(this.getName() + " слишком устал чтобы идти");
        }
    }


    public void think(Thoughts t) {
        delayP(this);
        System.out.println(this.getName() + " думаает: " + t.getThough());
        if(!t.isPositive()){
            this.setStamina(Math.max(this.getStamina()-3,0));
        }else{
            this.setStamina(Math.min(this.getStamina()+3,100));
        }
    }

    public void remember(Person p, Thoughts t) {
        delayP(this);
        System.out.println(this.getName() + " вспомианет слова " + p.getName() + "а: " + t.getThough());
        if(!t.isPositive()){
            this.setStamina(Math.max(this.getStamina()-5,0));
        }
    }

    public void say(String s) {
        System.out.println(this.getName() + ": " + "<<" + s + ">>");
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
            System.out.println(i.getName() + " не принадлежит вам");
        }

    }
}

