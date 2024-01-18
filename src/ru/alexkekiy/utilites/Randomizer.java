package ru.alexkekiy.utilites;

import ru.alexkekiy.exeptions.real.InputException;

public class Randomizer  {
    public static boolean chance(double i) throws InputException{
        if(i>1.0||i<0.0){
            throw new InputException("Значение передаваемое в  ru.alexkekiy.src.utilites.Randomizer.channce() должно принадлежать отрезку [0.0;1.0]");
        }
        return Math.random() > i;
    }
}
