package com.example.makarov.snakegame.objects;

import com.example.makarov.snakegame.direction.Moving;
import com.example.makarov.snakegame.direction.MovingObjectField;
import com.example.makarov.snakegame.direction.enumeration.Direction;

/**
 * Класс стенки
 */
public class Wall implements FieldObject{

    public static final int CODE_WALL_ON_THE_MAP = 5;
    private Moving mMoving = new MovingObjectField();
    private int mX;
    private int mY;

    /**
     * Задаём начальное направление движения
     */
    public Wall(){ mMoving.setDirection(Direction.UNMOVING);
    }

    @Override
    public void setXY(int x, int y){
        setX(x);
        setY(y);
    }

    private void setX(int x) {
        this.mX = x;
    }

    private void setY(int y) {
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
    public int getCode() {
        return CODE_WALL_ON_THE_MAP;
    }

    @Override
    public Moving getMoving() {
        return mMoving;
    }
}
