package com.example.makarov.snakegame.direction;

import com.example.makarov.snakegame.enumeration.Direction;
/**
 * Класс направление движением объектов поля
 */
public class DirectionOfMotionObjectField implements DirectionOfMotion {

    private Direction mDirection ;
    /**
     * Изменияем направление
     */
    @Override
    public void setDirection(Direction newDirection) {
        this.mDirection = newDirection;
    }
    /**
     * Возвращаем текущие направление
     */
    @Override
    public Direction getDirection() {
        return this.mDirection;
    }
}
