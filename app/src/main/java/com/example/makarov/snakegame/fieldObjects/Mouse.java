package com.example.makarov.snakegame.fieldObjects;


import com.example.makarov.snakegame.enumeration.Direction;

public class Mouse implements FieldObject {
    /**
     * Класс мышки
     */
    public static final int CODE_MOUSE_ON_THE_MAP = 5;
    private int mX;
    private int mY;
    private Direction mDirection ;

    public Mouse(int x, int y, Direction direction){
        this.mDirection = direction;
        this.mX = x;
        this.mY = y;
    }

    @Override
    public void setX(int x) {
        this.mX = x;
    }

    @Override
    public void setY(int y) {
        this.mY = y;
    }

    @Override
    public int getX() {
        return this.mX;
    }

    @Override
    public int getY() {
        return this.mY;
    }

    @Override
    public int getCodeOnTheMap() {
        return this.CODE_MOUSE_ON_THE_MAP;
    }
    /**
     * Сет и Гет метод переменной направления мышки : Юг, Запад ...
     */
    public void setDirection(Direction newDirection) {
        this.mDirection = newDirection;
    }

    public Direction getDirection() {
        return this.mDirection;
    }

}
