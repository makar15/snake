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
    /**
     * Метод каждого последующего шага змейки
     */
    @Override
    public void nextMove() {
        nextMoveBody();
        nextMoveHead();
    }
    /**
     * Метод добавления компоненты змейки вперед (с головы состава)
     */
    private void nextMoveBody() {
        mSnake.addComponentSnake(mSnake.getLastComponentSnake().getX() + mSnake.getDirection().deltaX(),
                mSnake.getLastComponentSnake().getY() + mSnake.getDirection().deltaY());
    }
    /**
     * Метод удаления компоненты змейки, в случае если она не должна рости, с конца(хвоста состава)
     */
    private void nextMoveHead() {
        if(mSnake.getIsGrowing() <= 0) mSnake.removeFirstComponentSnake();
        else mSnake.reduceIsGrowing(1);
    }
    /**
     * Вернуть объект над которым управляет данный контроллер
     */
    @Override
    public FieldObject getObject() {
        return this.mSnake;
    }

}
