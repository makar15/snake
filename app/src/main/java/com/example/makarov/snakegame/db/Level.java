package com.example.makarov.snakegame.db;

import com.example.makarov.snakegame.singleton.DataBase;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Класс связанный с Realm хранением данных(Храним созданные уровни)
 */
public class Level extends RealmObject {

    /**
     * Храним Имя уровня и строку уровня(в дальнейшем переработанную в объекты уровня и поле)
     */

    public static final String NAME_ID = "name";
    public static final String NAME_FIRST_LEVEL = "first";

    private String name;
    private String body;

    @PrimaryKey
    private int id;

    public Level(){

    }

    public Level(String name, String modelLevel) {
        setName(name);
        setId(name.hashCode());
        setBody(modelLevel);
    }

    /**
     * Сет и Гет методы
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
