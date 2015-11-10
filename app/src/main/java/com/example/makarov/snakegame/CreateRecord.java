package com.example.makarov.snakegame;

/**
 * Класс текущего рекорда
 * создается в каждой запущенной игре
 * Для удобства записи и взятия данных о рекорде
 * В классе потоке (где проше всего записываю очки набранные змейкой,
 * в классе диалоге из EditText беру name пользователя
 */
public class CreateRecord {

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
