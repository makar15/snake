package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.objects.Vegetable;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс обработки столкновения змеи об овощь
 */
public class CollisionSnakesVegetables implements HandlerCollision<Snake, Vegetable>{

    private final MyField mField;
    private int REDUCE_SPEED_DUE_TO_VEGETABLE = 100;
    private int ADD_SCORE_DUE_TO_VEGETABLE = 20;

    public CollisionSnakesVegetables(MyField field){
        this.mField = field;
    }

    /**
     *
     */
    @Override
    public void processingCollision(Snake objectFirst, Vegetable objectSecond){
        objectFirst.reduceSpeed(REDUCE_SPEED_DUE_TO_VEGETABLE);
        objectFirst.getScore().addScore(ADD_SCORE_DUE_TO_VEGETABLE);
        mField.changeObjectLocation(objectFirst, objectSecond.getX(), objectSecond.getY());
        mField.changeObjectLocationRandom(objectSecond);
    }
}
