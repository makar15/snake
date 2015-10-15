package com.example.makarov.snakegame.fieldObjects;


public interface FieldObject {
    /**
     * Интерфейс объектов поля
     */
    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    int getCodeOnTheMap();

}
