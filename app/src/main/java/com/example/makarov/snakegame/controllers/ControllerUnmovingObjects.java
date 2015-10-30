package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.playingField.ControllerField;
import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
/**
 * Класс контроллера для недвижущихся объектов
 * В конструктор поле(карта игры) и объект над кем будет управление
 */
public class ControllerUnmovingObjects extends Controller<FieldObject>{

    private Field mField;
    private ControllerField mControllerField;
    /**
     * В конструктор поле(карта игры) и объект над кем будет управление
     * Ставим начальное месторасположение фрукта на карте
     */
    public ControllerUnmovingObjects(Field field, FieldObject fieldObject){
        super(fieldObject);
        this.mField = field;
        mControllerField = new ControllerField(mField);

        mField.addObject(mObject, 26, 29);
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
    public Field getField() {
        return mField;
    }

}
