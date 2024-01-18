package ru.alexkekiy.items;

import ru.alexkekiy.enums.ItemSeize;

public class Food extends Item {
    private final int calories;
    public Food(int c, ItemSeize i, String n) {
        super(i, n);
        this.calories = Math.max(c, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            Food f = (Food) o;
            return this.calories == f.calories;
        } else return false;
    }

    public int getCalories() {
        return calories;
    }

}
