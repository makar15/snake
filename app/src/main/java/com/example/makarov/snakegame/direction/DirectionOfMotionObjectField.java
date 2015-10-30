package com.example.makarov.snakegame.direction;

import android.view.MotionEvent;
import com.example.makarov.snakegame.enumeration.Direction;
/**
 * Класс направление движением объектов поля
 */
public class DirectionOfMotionObjectField implements DirectionOfMotion {

    private Direction mDirection ;
    int clicX;
    int clicY;
    /**
     * Изменияем направление
     */
    @Override
    public void setDirection(Direction newDirection) {
        this.mDirection = newDirection;
    }
    /**
     * Возвращаем текущие направление
     */
    @Override
    public Direction getDirection() {
        return this.mDirection;
    }
    /**
     *

    public boolean onTouchEvent(MotionEvent e){
        clicX = (int) e.getX();
        clicY = (int) e.getY();

        if(clicX > 1080/2 && clicY > 1920/2){
            setDirection(Direction.RIGHT);
        } else if(clicX < 1080/2 && clicY > 1920/2){
            setDirection(Direction.DOWN);
        }else if(clicX < 1080/2 && clicY < 1920/2){
            setDirection(Direction.LEFT);
        }else if(clicX > 1080/2 && clicY < 1920/2){
            setDirection(Direction.UP);
        }
        return true;
    }*/
}
