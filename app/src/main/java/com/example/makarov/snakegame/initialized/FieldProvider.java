package com.example.makarov.snakegame.initialized;

import android.view.View;

/**
 * Класс размеров поля
 */
public class FieldProvider {

    private int mWidth;
    private int mHeight;
    private int widthScreen;
    private int heightScreen;
    private int widthOneScreen;
    private int heightOneScreen;

    /**
     * View узнаем высоту и ширину экрана на котором происходит отрисовка
     * Узнаём общий размер экрна и размер одной клетки игры в пикселях
     */
    public FieldProvider(View surfaceView, int width, int height){

        mWidth = width;
        mHeight = height;

        widthScreen = surfaceView.getWidth();
        heightScreen = surfaceView.getHeight();

        widthOneScreen = widthScreen / width;
        heightOneScreen = heightScreen / height;

    }

    /**
     *Вернуть:
     * ширину и высоту поля в клетках матрицы
     *Вернуть (в пикселяях):
     * ширину и высоту одной клетки поля
     * ширину и высоту всего поля
     * ширину и высоту до координат
     */
    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getHeightOneScreen() {
        return heightOneScreen;
    }

    public int getWidthOneScreen() {
        return widthOneScreen;
    }

    public int getWidthScreen() {
        return widthScreen;
    }

    public int getHeightScreen() {
        return heightScreen;
    }

    public int getScreenX(int fieldX){
        return fieldX * widthOneScreen;
    }

    public int getScreenY(int fieldY){
        return fieldY * heightOneScreen;
    }

}
