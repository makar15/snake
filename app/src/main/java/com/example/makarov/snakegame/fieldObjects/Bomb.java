package com.example.makarov.snakegame.fieldObjects;


public class Bomb implements FieldObject {
    /**
     * Класс бомбы
     */
    public static final int CODE_BOMB_ON_THE_MAP = 4;
    private int mX;
    private int mY;

    public Bomb(int x, int y){
        this.mX = x;
        this.mY = y;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

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
