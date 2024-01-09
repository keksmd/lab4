package enums;
public enum Thoughts {
    LUIS1(" Не очень похоже на Кладбище домашних животных "),
    LUIS2(" Луис, что ты здесь делаешь? Ты забыл — ты не должен ходить этой дорогой!"),
    LUIS3("Уединенное место, но, однако, никто не пойдет сюда целоваться");

    private Thoughts(String though) {
        this.though = though;
    }
    private final String though;
    public String getThough(){
        return this.though;
    }


}