package com.example.makarov.snakegame.fieldObjects;

import com.example.makarov.snakegame.direction.DirectionOfMotion;
import com.example.makarov.snakegame.direction.DirectionOfMotionObjectField;
import com.example.makarov.snakegame.enumeration.Direction;
/**
 * Класс тестОбъекта
 */
public class TestObjectField implements FieldObject {

    public static final int CODE_TEST_OBJECT_ON_THE_MAP = 5;
    private DirectionOfMotion mDirectionOfMotion = new DirectionOfMotionObjectField();
    private int mX;
    private int mY;
    /**
     * Задаём начальное направление движения
     */
    public TestObjectField(){
        this.mDirectionOfMotion.setDirection(Direction.RIGHT);
    }

    @Override
    public void setX(int x) {
        this.mX = x;
    }

    @Override
    public void setY(int y) {
        this.mY = y;
    }

    @Override
    public int getX() {
        return this.mX;
    }

    @Override
    public int getY() {
        return this.mY;
    }

    @Override
    public int getCodeOnTheMap() {
        return this.CODE_TEST_OBJECT_ON_THE_MAP;
    }

    public DirectionOfMotion getDirectionOfMotion() {
        return mDirectionOfMotion;
    }

}
