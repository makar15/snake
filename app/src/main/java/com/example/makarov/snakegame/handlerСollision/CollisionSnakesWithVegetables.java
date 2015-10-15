package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.playingField.Field;

public class CollisionSnakesWithVegetables implements HandlerCollision{
    /**
     * Класс обработки столкновения змеи об овощь
     * если змейка попадет на овощь:
     * очки игры увеличаться и увеличиться скорость
     */
    private final Field mField;
    private int ADD_SPEED_DUE_TO_VEGETABLE = -50;
    private int ADD_SCORE_DUE_TO_VEGETABLE = 15;

    public CollisionSnakesWithVegetables(Field field){
        this.mField = field;
    }
    /**
     *
     */
    @Override
    public void processingCollision(FieldObject object, int x, int y){

    }
}
