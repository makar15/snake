package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.TestObject;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс обработки столкновения тестОбъекта столкнувшегося об фрукт
 */
public class CollisionTestObjectFruit implements HandlerCollision<TestObject, Fruite>{

    private final MyField mField;

    public CollisionTestObjectFruit(MyField field){
        this.mField = field;
    }

    /**
     * Метод ставит тестОбъект на место где стоял фрукт,
     * а фрукт удаляет с карты
     */
    @Override
    public void processingCollision(TestObject objectFirst, Fruite objectSecond) {
        mField.changeObjectLocation(objectFirst, objectSecond.getX(), objectSecond.getY());
        mField.removeObject(objectSecond);
    }
}
