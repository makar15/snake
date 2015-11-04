package com.example.makarov.snakegame.handler;

import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс обработки столкновения змеи об фрукт
 * змейка попадет на фрукт:
 * прибавяться очки игры и увеличиться переменная роста змеи
 */
public class CollisionSnakeFruit implements HandlerCollision<Snake, Fruite>{

    private final MyField mField;
    private int ADD_SCORE_DUE_TO_FRUITE = 10;
    private int ADD_IS_GROWING_DUE_TO_FRUITE = 2;

    public CollisionSnakeFruit(MyField field){
        this.mField = field;
    }

    /**
     *В методе изменения переменных очков набранных змейкой и переменной роста змейки,
     * а так же, удаление с поля и добавление на другом месте поля,
     * объекта(фрукта) стоящего на координатах и продвижение змейки по полю
     */
    @Override
    public void processingCollision(Snake objectFirst, Fruite objectSecond){
        mField.changeObjectLocation(objectFirst, objectSecond.getX(), objectSecond.getY());
        mField.removeObject(objectSecond);
        objectFirst.addScore(ADD_SCORE_DUE_TO_FRUITE);
        objectFirst.addGrowing(ADD_IS_GROWING_DUE_TO_FRUITE);
    }
}
