package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Snake;
/**
 * Класс контроллера змейки
 */
public class ControlTheSnake implements ObjectController {

    private Snake mSnake;
    private Field mField;

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
     * Вернуть объект над которым управляет данный контроллер
     */
    @Override
    public FieldObject getObject() {
        return this.mSnake;
    }
    /**
     * Метод добавления компоненты змейки вперед (с головы состава)
     */
    private void nextMoveBody() {
        mSnake.upSnakeLength(mSnake.getHeadSnake().getX() +
                        mSnake.getDirectionOfMotion().getDirection().deltaX(),
                mSnake.getHeadSnake().getY() +
                        mSnake.getDirectionOfMotion().getDirection().deltaY());
    }
    /**
     * Метод удаления компоненты змейки, в случае если она не должна рости, с конца(хвоста состава)
     */
    private void nextMoveHead() {
        if(mSnake.getGrowing() <= 0) {
            mSnake.removeFirstComponentSnake();
        } else{
            mSnake.reduceGrowing(1);
        }
    }

}
