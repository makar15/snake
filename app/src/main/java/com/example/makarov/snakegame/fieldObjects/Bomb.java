package com.example.makarov.snakegame.fieldObjects;

/**
 * Класс бомбы
 */
public class Bomb implements FieldObject {

    public static final int CODE_BOMB_ON_THE_MAP = 13;
    private int mX;
    private int mY;

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
        return this.CODE_BOMB_ON_THE_MAP;
    }

}
