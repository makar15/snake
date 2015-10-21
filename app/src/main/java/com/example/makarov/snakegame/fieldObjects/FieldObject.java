package com.example.makarov.snakegame.fieldObjects;

/**
 * Интерфейс объектов поля
 */
public interface FieldObject {

    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    int getCodeOnTheMap();

}
