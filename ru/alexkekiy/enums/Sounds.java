package ru.alexkekiy.enums;

public enum Sounds {
    SKRIP(" *СКРИП-СКРИП* "),
    SHELK(" *ЩЕЛК* "),
    SHURSH(" *ШРХХХ* ");
    private final String sound;
    Sounds(String sound) {
        this.sound = sound;
    }



    public String getSound() {
        return this.sound;
    }


}
