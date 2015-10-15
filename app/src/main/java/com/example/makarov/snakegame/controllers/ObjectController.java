package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.fieldObjects.FieldObject;

public interface ObjectController {
    /**
     * Интерфейс контроллеров
     */
    boolean nextMove();

    FieldObject getObject();

}
