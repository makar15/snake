package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Fruite;

public interface ObjectController {
    /**
     * Интерфейс контроллеров
     */
    void nextMove();

    FieldObject getObject();

}
