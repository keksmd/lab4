package enums;

public enum Sounds {
    SKRIP(" *СКРИП-СКРИП* "),
    SHELK(" *ЩЕЛК* "),
    SHURSH(" *ШРХХХ* ");

    private Sounds(String sound) {
        this.sound = sound;
    }
    private final String sound;
    public String getSound(){
        return this.sound;
    }


}
