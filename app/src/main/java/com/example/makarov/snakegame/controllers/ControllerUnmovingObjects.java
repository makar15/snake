package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.fieldObjects.FieldObject;

public class ControllerUnmovingObjects implements  ObjectController{
    /**
     * Класс контроллера для недвижущихся объектов
     * В конструктор поле(карта игры) и объект над кем будет управление
     */
    private final FieldObject mFieldObject;
    private final Field mField;

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

    private void changeLocation(){

    }

}
