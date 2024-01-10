package ru.alexkekiy.items;

import ru.alexkekiy.enums.ItemSeize;

public class Food extends Item {
    public Food(int c, ItemSeize i, String n) {
        super(i, n);
        if (c > 0) {
            this.calories = c;
        } else {
            this.calories = 0;
        }
    }

    private final int calories;

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
