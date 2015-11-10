package com.example.makarov.snakegame.db;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Класс связынныз с Realm хранением данных
 */
public class Record extends RealmObject {

    /**
     * Храним Имя пользователя и набранные им очки
     */
    @PrimaryKey
    private String name;
    private int score;

    @Ignore
    private int sessionId;

    /**
     * Сет и Гет методы
     */
    public void setName(String mName) {
        this.name = mName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getScore() {
        return score;
    }

}
