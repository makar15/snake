package com.example.makarov.snakegame.direction;

import com.example.makarov.snakegame.enumeration.Direction;
/**
 * Интерфейс направление движения
 */
public interface DirectionOfMotion {
    /**
     * Метод изменения направления
     */
    void setDirection(Direction direction);
    /**
     * Метод возврата текущего направления
     */
    Direction getDirection();
}
