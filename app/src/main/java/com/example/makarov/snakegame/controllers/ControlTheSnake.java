package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.fieldObjects.Snake;
/**
 * Класс контроллера змейки
 */
public class ControlTheSnake extends Controller<Snake> {

    private Field mField;

    public ControlTheSnake(Field field, Snake snake){
        super(snake);
        mField = field;
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
     *
     */
    @Override
    public Field getField() {
        return mField;
    }
    /**
     * Метод добавления компоненты змейки вперед (с головы состава)
     */
    private void nextMoveBody() {
        mObject.upSnakeLength(mObject.getHeadSnake().getX() +
                        mObject.getDirectionOfMotion().getDirection().deltaX(),
                mObject.getHeadSnake().getY() +
                        mObject.getDirectionOfMotion().getDirection().deltaY());
    }
    /**
     * Метод удаления компоненты змейки, в случае если она не должна рости, с конца(хвоста состава)
     */
    private void nextMoveHead() {
        if(mObject.getGrowing() <= 0) {
            mObject.removeFirstComponentSnake();
        } else{
            mObject.reduceGrowing(1);
        }
    }

}
