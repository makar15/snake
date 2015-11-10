package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс обработки столкновения змеи об фрукт
 */
public class CollisionSnakeFruit implements HandlerCollision<Snake, Fruite>{

    private final MyField mField;
    private int ADD_SCORE_DUE_TO_FRUITE = 35;
    private int ADD_IS_GROWING_DUE_TO_FRUITE = 1;

    public CollisionSnakeFruit(MyField field){
        this.mField = field;
    }

    /**
     *
     */
    @Override
    public void processingCollision(Snake objectFirst, Fruite objectSecond){
        objectFirst.getScore().addScore(ADD_SCORE_DUE_TO_FRUITE);
        objectFirst.addGrowing(ADD_IS_GROWING_DUE_TO_FRUITE);
        mField.changeObjectLocation(objectFirst, objectSecond.getX(), objectSecond.getY());
        mField.changeObjectLocationRandom(objectSecond);
    }
}
