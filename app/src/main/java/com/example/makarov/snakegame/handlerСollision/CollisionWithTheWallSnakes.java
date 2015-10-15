package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.playingField.Field;

public class CollisionWithTheWallSnakes implements HandlerCollision{
    /**
     * Класс обработки столкновения змеи об стенку
     * змея умрет при столкновении
     */
    private final Field mField;

    public CollisionWithTheWallSnakes(Field field){
        this.mField = field;
    }
    /**
     *
     */
    @Override
    public void processingCollision(FieldObject object, int x, int y) {

    }
}
