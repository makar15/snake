package com.example.makarov.snakegame;

/**
 * Класс текущего рекорда
 * создается в каждой запущенной игре
 * В классе потоке запись очков набранных змейкой,
 * в классе диалоге, из EditText, запись name пользователя
 */
public class Record {

    private String name;
    private int score;

    /**
     * Сет и Гет методы набранных очков игры и имени пользователя
     */
    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
