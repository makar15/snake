package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
/**
 * Интерфейс контроллеров
 */
public interface ObjectController {

    void nextMove();

    FieldObject getObject();

}
