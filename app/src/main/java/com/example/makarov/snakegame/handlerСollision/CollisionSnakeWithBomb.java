package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.playingField.Field;
/**
 * Класс обработки столкновения змеи об бомбу
 * если змейка попадет на бомбу:
 * все очки игры обнуляться и увеличиться скорость
 */
public class CollisionSnakeWithBomb implements HandlerCollision{

    private final Field mField;
    private int ADD_SPEED_DUE_TO_VEGETABLE = -100;

    public CollisionSnakeWithBomb(Field field){
        this.mField = field;
    }
    /**
     *
     */
    @Override
    public void processingCollision(FieldObject object, int x, int y){

    }
}
