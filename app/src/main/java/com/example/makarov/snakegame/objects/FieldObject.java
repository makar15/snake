package com.example.makarov.snakegame.objects;

import com.example.makarov.snakegame.direction.Moving;

/**
 * Интерфейс объектов поля
 */
public interface FieldObject {

    /**
     * изменить координаты (x ,y) объекта
     */
    void setXY(int x, int y);

    /**
     * вернуть X координату объекта
     */
    int getX();

    /**
     * вернуть Y координату объекта
     */
    int getY();

    /**
     * Вернуть код объекта
     */
    int getCode();

    /**
     * вернуть объект решающий движением объекта
     */
    Moving getMoving();

}
