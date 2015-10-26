package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.Fruite;
import com.example.makarov.snakegame.fieldObjects.Snake;
import com.example.makarov.snakegame.playingField.Field;
/**
 * Класс обработки столкновения змеи об фрукт
 * змейка попадет на фрукт:
 * прибавяться очки игры и увеличиться переменная роста змеи
 */
public class CollisionWithSnakeFruit implements HandlerCollision<Snake, Fruite>{

    private final Field mField;
    private int ADD_SCORE_DUE_TO_FRUITE = 10;
    private int ADD_IS_GROWING_DUE_TO_FRUITE = 2;

    public CollisionWithSnakeFruit(Field field){
        this.mField = field;
    }
    /**
     *В методе изменения переменных очков набранных змейкой и переменной роста змейки,
     * а так же, удаление с поля и добавление на другом месте поля,
     * объекта(фрукта) стоящего на координатах и продвижение змейки по полю
     */
    @Override
    public void processingCollision(Snake objectFirst, Fruite objectSecond){

    }
}
