package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.objects.Wall;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс обработки столкновения объекта движущегося об стенку
 */
public class CollisionSnakesWall implements HandlerCollision<Snake, Wall>{

    private final MyField mField;

    public CollisionSnakesWall(MyField field){
        this.mField = field;
    }

    /**
     *
     */
    @Override
    public void processingCollision(Snake objectFirst, Wall objectSecond) {
        mField.removeObject(objectFirst);
    }
}
