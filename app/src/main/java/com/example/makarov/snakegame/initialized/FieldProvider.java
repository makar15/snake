package com.example.makarov.snakegame.initialized;

import android.view.SurfaceHolder;
import com.example.makarov.snakegame.playingField.Field;
import android.graphics.Canvas;
/**
 * Класс размеров поля
 */
public class FieldProvider {

    //private Canvas mCanvas = null;
    private final int wightScreen = 1080;
    private final int heightScreen = 1920;
    private final int widthOne;
    private final int heightOne;
    /**
     * Канвасом узнаем высоту и ширину экрана на котором происходит отрисовка всех объектов игры
     * Высчитываем сколько одна клетка поля будет размером в пикселях на экране
     */
    public FieldProvider(SurfaceHolder surfaceHolders, Field field){
        /**
         * Тут тоже ругалось и я пока решил закомментировать, что б другие баги править
         * Тоже писал вроде что на нулевой объект ссылаюсь
         */
        //mCanvas = surfaceHolders.lockCanvas(null);
        //wightScreen = mCanvas.getWidth();
        //heightScreen = mCanvas.getHeight();
        //surfaceHolders.unlockCanvasAndPost(mCanvas);

        widthOne = wightScreen / field.getWidth();
        heightOne = heightScreen / field.getHeight();

    }
    /**
     *Вернуть:
     * ширину и высоту одной клетки поля
     * ширину и высоту всего поля
     * ширину и высоту до координат
     */
    public int getHeightOne() {
        return heightOne;
    }

    public int getWidthOne() {
        return widthOne;
    }

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