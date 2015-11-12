package com.example.makarov.snakegame.db;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Класс связанный с Realm хранением данных(Храним созданные уровни)
 */
public class BaseLevels extends RealmObject {

    /**
     * Храним Имя уровня и строку уровня(в дальнейшем переработанную в объекты уровня и поле)
     */
    private String name;
    private String modelLevel;

    @Ignore
    private int sessionId;

    /**
     * Сет и Гет методы
     */
    public void setName(String mName) {
        this.name = mName;
    }

    public void setModelLevel(String model) {
        this.modelLevel = model;
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

    public String getModelLevel() {
        return modelLevel;
    }
}
