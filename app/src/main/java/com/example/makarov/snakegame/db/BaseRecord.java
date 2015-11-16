package com.example.makarov.snakegame.db;

import io.realm.RealmObject;

/**
 * Класс связанный с Realm хранением данных(Храним рекорды игр)
 */
public class BaseRecord extends RealmObject {

    /**
     * Храним Имя пользователя и набранные им очки
     */
    private String name;
    private int score;

    public BaseRecord(){

    }
    /**
     * Сет и Гет методы
     */
    public void setName(String mName) {
        this.name = mName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

}
