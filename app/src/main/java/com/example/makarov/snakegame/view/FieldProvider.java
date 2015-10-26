package com.example.makarov.snakegame.view;

import android.graphics.Canvas;
import com.example.makarov.snakegame.playingField.Field;
/**
 * Класс размеров поля
 */
public class FieldProvider {

    private final int wightScreen;
    private final int heightScreen;

    private final int widthOne;
    private final int heightOne;
    /**
     * Канвасом узнаем высоту и ширину экрана на котором происходит отрисовка всех объектов игры
     * Высчитываем сколько одна клетка поля будет размером в  пикселях на экране
     */
    public FieldProvider(Canvas canvas, Field field){
        wightScreen = canvas.getWidth();
        heightScreen = canvas.getHeight();

        widthOne = wightScreen / field.getWidth();
        heightOne = heightScreen / field.getHeight();

    }
    /**
     * Методы возврата высоты и щирины всего экрана,
     * и возврат высоты и ширины одной клетки игрового  поля
     */
    public int getWightScreen() {
        return wightScreen;
    }

    public int getHeightScreen() {
        return heightScreen;
    }

    public int getScreenX(int fieldX){
        return fieldX * widthOne;
    }

    public int getScreenY(int fieldY){
        return fieldY * heightOne;
    }

}
