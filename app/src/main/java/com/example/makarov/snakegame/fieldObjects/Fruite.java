package com.example.makarov.snakegame.fieldObjects;


public class Fruite implements  FieldObject{
    /**
     * Класс фрукта
     */
    public static final int CODE_FRUITE_ON_THE_MAP = 2;
    private int mX;
    private int mY;

    public Fruite(int x, int y){
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
        return this.CODE_FRUITE_ON_THE_MAP;
    }

}
