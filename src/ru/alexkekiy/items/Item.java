package ru.alexkekiy.items;

import ru.alexkekiy.enums.ItemSeize;
import ru.alexkekiy.ownable.Ownable;

public class Item {
    private final String name;
    private final ItemSeize seize;
    private Ownable owner;

    public Item(ItemSeize i, String n) {
        this.seize = i;
        this.name = n;
    }


    public String getName() {
        return name;
    }
    public Ownable getOwner() {
        return owner;
    }
    public void setOwner(Ownable owner) {
        this.owner = owner;
    }

    public ItemSeize getSeize() {
        return seize;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Item item2 = (Item) o;
        return item2.name.equals(this.name)
                && item2.owner.equals(this.owner)
                && item2.seize.equals(this.seize)
                && item2.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s of %s ",this.getName() , this.getClass());
    }

    @Override
    public int hashCode() {
        if (name != null) {
            return 5 * name.hashCode() + seize.hashCode() - owner.hashCode();
        } else {
            return 0;
        }
    }

}
