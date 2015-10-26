package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.Snake;
import com.example.makarov.snakegame.fieldObjects.Wall;
import com.example.makarov.snakegame.playingField.Field;
/**
 * Класс обработки столкновения объекта движущегося об стенку
 */
public class CollisionWithTheWallMovingObjectField implements HandlerCollision<Snake, Wall>{

    private final Field mField;

    public CollisionWithTheWallMovingObjectField(Field field){
        this.mField = field;
    }
    /**
     *
     */
    @Override
    public void processingCollision(Snake objectFirst, Wall objectSecond) {

    }
}
