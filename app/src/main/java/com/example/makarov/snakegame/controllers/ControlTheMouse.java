package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Mouse;
import com.example.makarov.snakegame.playingField.Field;

/**
 * Класс контроллера мышки
 */
public class ControlTheMouse implements ObjectController {
    /**
     * Класс контроллера мышки
     */
    private final Mouse mMouse;
    private final Field mField;

    public ControlTheMouse(Field field, FieldObject mFieldObject){
        this.mField = field;
        this.mMouse = (Mouse) mFieldObject;
    }
    /**
     * Метод каждого последующего шага мышки
     */
    @Override
    public void nextMove() {
        nextMoveBody();
    }
    /**
     * Метод перемещения мышки на следующую клетку по её направлению движения
     */
    private void nextMoveBody() {
        mMouse.setX(mMouse.getX() + mMouse.getDirection().deltaX());
        mMouse.setY(mMouse.getY() + mMouse.getDirection().deltaY());
    }
    /**
     * Вернуть объект над которым управляет данный контроллер
     */
    @Override
    public FieldObject getObject() {
        return this.mMouse;
    }

}
