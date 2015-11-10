package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.objects.Bomb;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс обработки столкновения змеи об бомбу
 */
public class CollisionSnakeBomb implements HandlerCollision<Snake, Bomb>{

    private final MyField mField;
    private int REDUCE_SPEED_DUE_TO_BOMB = 100;
    private int REDUCE_SCORE_DUE_TO_BOMB = 15;

    public CollisionSnakeBomb(MyField field){
        this.mField = field;
    }

    /**
     *
     */
    @Override
    public void processingCollision(Snake objectFirst, Bomb objectSecond){
        objectFirst.reduceSpeed(REDUCE_SPEED_DUE_TO_BOMB);
        objectFirst.getScore().reduceScore(REDUCE_SCORE_DUE_TO_BOMB);
        mField.changeObjectLocation(objectFirst, objectSecond.getX(), objectSecond.getY());
        mField.changeObjectLocationRandom(objectSecond);
    }
}
