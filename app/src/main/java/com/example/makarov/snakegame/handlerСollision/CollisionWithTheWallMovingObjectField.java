package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.playingField.Field;
/**
 * Класс обработки столкновения объекта движущегося об стенку
 */
public class CollisionWithTheWallMovingObjectField implements HandlerCollision{

    private final Field mField;

    public CollisionWithTheWallMovingObjectField(Field field){
        this.mField = field;
    }
    /**
     *
     */
    @Override
    public void processingCollision(FieldObject object, int x, int y) {

    }
}
