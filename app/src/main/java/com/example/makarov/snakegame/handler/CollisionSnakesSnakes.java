package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.direction.enumeration.Direction;
import com.example.makarov.snakegame.field.MyField;
import com.example.makarov.snakegame.objects.Snake;

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
        if(objectFirst.getMoving().getDirection() != Direction.UNMOVING) {
            mField.removeObject(objectFirst);
        }
    }
}
