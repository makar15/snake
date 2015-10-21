package com.example.makarov.snakegame.fieldObjects;

import com.example.makarov.snakegame.direction.DirectionOfMotion;
/**
 * Интерфейс движущихся объектов поля
 */
public interface MovingObjectField extends FieldObject{

    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    int getCodeOnTheMap();

    DirectionOfMotion getDirectionOfMotion();
}
