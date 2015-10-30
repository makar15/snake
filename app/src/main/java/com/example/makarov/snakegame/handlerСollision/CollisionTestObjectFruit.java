package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.Fruite;
import com.example.makarov.snakegame.fieldObjects.TestObject;
import com.example.makarov.snakegame.playingField.Field;
/**
 * Класс обработки столкновения тестОбъекта столкнувшегося об фрукт
 */
public class CollisionTestObjectFruit implements HandlerCollision<TestObject, Fruite>{

    private final Field mField;

    public CollisionTestObjectFruit(Field field){
        this.mField = field;
    }
    /**
     * Метод ставит тестОбъект на место где стоял фрукт,
     * а фрукт переносит на другое рандомное место на карте
     */
    @Override
    public void processingCollision(TestObject objectFirst, Fruite objectSecond) {
        mField.changeObjectLocation(objectFirst, objectSecond.getX(), objectSecond.getY());
        mField.removeObject(objectSecond);
    }
}
