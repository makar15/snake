package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.objects.FieldObject;
import com.example.makarov.snakegame.field.MyField;

/**
 * Интерфейс контроллеров
 */
public interface ObjectController<T extends FieldObject> {

    void nextMove();

    T getObject();

    MyField getField();

}
