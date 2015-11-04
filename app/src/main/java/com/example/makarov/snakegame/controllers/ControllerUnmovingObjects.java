package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.field.ControllerField;
import com.example.makarov.snakegame.objects.FieldObject;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс контроллера для недвижущихся объектов
 */
public class ControllerUnmovingObjects extends Controller{

    private MyField mField;
    private ControllerField mControllerField;

    /**
     * В конструктор поле(карта игры) и объект над кем будет управление
     */
    public ControllerUnmovingObjects(MyField field, FieldObject fieldObject){
        super(fieldObject);
        this.mField = field;
        mControllerField = new ControllerField(mField);

    }

    /**
     * Объект не передвигаем!
     */
    @Override
    public void nextMove() {

    }

    /**
     * Вернуть объект над которым управляет данный контроллер
     */
    @Override
    public FieldObject getObject() {
        return this.mObject;
    }

    /**
     * Вернуть поле на котором происходит передвижение объекта
     */
    @Override
    public MyField getField() {
        return mField;
    }

}
