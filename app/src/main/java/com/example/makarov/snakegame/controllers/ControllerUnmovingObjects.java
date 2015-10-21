package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
/**
 * Класс контроллера для недвижущихся объектов
 * В конструктор поле(карта игры) и объект над кем будет управление
 */
public class ControllerUnmovingObjects implements  ObjectController{
    /**
     * В конструктор поле(карта игры) и объект над кем будет управление
     */
    private FieldObject mFieldObject;
    private Field mField;

    public ControllerUnmovingObjects(Field field, FieldObject mFieldObject){
        this.mField = field;
        this.mFieldObject = mFieldObject;
    }

    @Override
    public void nextMove() {

    }

    @Override
    public FieldObject getObject() {
        return this.mFieldObject;
    }

}
