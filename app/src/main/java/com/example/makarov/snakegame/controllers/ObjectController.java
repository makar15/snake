package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.playingField.Field;

/**
 * Интерфейс контроллеров
 */
public interface ObjectController<T extends FieldObject> {

    void nextMove();

    T getObject();

    Field getField();

}
