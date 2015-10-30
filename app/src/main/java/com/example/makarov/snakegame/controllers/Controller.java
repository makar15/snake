package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
/**
 * Абстрактный класс контроллеров обобщенного типа
 */
public abstract class Controller<T extends FieldObject> implements ObjectController<T> {

    protected final T mObject;
    /**
     * Конструктор для хранения объекта обобщенного типа
     */
    public Controller(T object){
        mObject = object;
    }
    /**
     * Гет метод объекта
     */
    @Override
    public T getObject() {
        return mObject;
    }

}
