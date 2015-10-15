package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Snake;

public class ControlTheSnake implements ObjectController {
    /**
     * Класс контроллера змейки
     */
    private final Snake mSnake;
    private final Field mField;

    public ControlTheSnake(Field field, FieldObject mFieldObject){
        this.mField = field;
        this.mSnake = (Snake) mFieldObject;
    }

    @Override
    public boolean nextMove() {

        return false;
    }

    @Override
    public FieldObject getObject() {
        return this.mSnake;
    }

}
