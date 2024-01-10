package ru.alexkekiy.items;

import ru.alexkekiy.enums.ItemSeize;
import ru.alexkekiy.ownable.Ownable;

public class Item {
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
        return this.getName() + " of " + this.getClass();
    }

    @Override
    public int hashCode() {
        if (name != null) {
            return 5 * name.hashCode() + seize.hashCode() - owner.hashCode();
        } else {
            return 0;
        }
    }

    public Item(ItemSeize i, String n) {
        this.seize = i;
        this.name = n;
    }

    private final String name;

    public String getName() {
        return name;
    }

    private final ItemSeize seize;
    private Ownable owner;

    public Ownable getOwner() {
        return owner;
    }

    public void setOwner(Ownable owner) {
        this.owner = owner;
    }

    public ItemSeize getSeize() {
        return seize;
    }

}
