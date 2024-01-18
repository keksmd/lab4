package ru.alexkekiy.enums;

public enum Thoughts {
    LUIS1(" Не очень похоже на Кладбище домашних животных ",false),
    LUIS2(" Луис, что ты здесь делаешь? Ты забыл — ты не должен ходить этой дорогой!",false),
    LUIS3("Уединенное место, но, однако, никто не пойдет сюда целоваться",false);

    private final String though;
    private final boolean positive;
    Thoughts(String though,boolean pos) {
        this.though = though;
        this.positive = pos;
    }


    public boolean isPositive(){
        return this.positive;
    }

    public String getThough() {
        return this.though;
    }


}