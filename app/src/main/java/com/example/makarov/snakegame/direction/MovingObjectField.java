package com.example.makarov.snakegame.direction;

import com.example.makarov.snakegame.direction.enumeration.Direction;

/**
 * Класс направление движением объектов поля
 */
public class MovingObjectField implements Moving {

    private Direction mDirection ;

    /**
     * Изменияем направление
     */
    @Override
    public void setDirection(Direction newDirection) {
        mDirection = newDirection;
    }

    /**
     * Возвращаем текущие направление
     */
    @Override
    public Direction getDirection() {
        return mDirection;
    }

}
