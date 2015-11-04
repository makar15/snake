package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.field.MyField;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.objects.Wall;

/**
 *
 */
public class CollisionSnakesSnakes implements HandlerCollision<Snake, Snake>{

    private final MyField mField;

    public CollisionSnakesSnakes(MyField field){
        this.mField = field;
    }

    /**
     *
     */
    @Override
    public void processingCollision(Snake objectFirst, Snake objectSecond) {
        mField.removeObject(objectFirst);
    }
}
