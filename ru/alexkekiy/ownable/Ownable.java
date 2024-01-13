package ru.alexkekiy.ownable;

abstract public class Ownable {
    private final String name;

    public Ownable(String n) {
        this.name = n;
    }
    @Override
    public String toString() {
        return this.getName() + " of " + this.getClass();
    }

    @Override
    public int hashCode() {
        if (name != null) {
            return 17 * name.hashCode();
        } else {
            return 0;
        }
    }




    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ownable own = (Ownable) o;
        return this.name.equals(own.name)
                && this.hashCode() == own.hashCode();
    }

}
