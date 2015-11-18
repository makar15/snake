package com.example.makarov.snakegame;

import android.view.View;

/**
 * Класс размеров поля
 */
public class FieldProvider {

    private int mWidth;
    private int mHeight;
    private final int widthScreen;
    private final int heightScreen;
    private float widthOneScreen;
    private float heightOneScreen;

    /**
     * Узнаем высоту и ширину экрана в пикселях
     * Узнаём общий размер экрана и размер одной клетки игры в пикселях
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

    public float getHeightOneScreen() {
        return heightOneScreen;
    }

    public float getWidthOneScreen() {
        return widthOneScreen;
    }

    public int getWidthScreen() {
        return widthScreen;
    }

    public int getHeightScreen() {
        return heightScreen;
    }

    public float getScreenX(int fieldX){
        return fieldX * widthOneScreen;
    }

    public float getScreenY(int fieldY){
        return fieldY * heightOneScreen;
    }

}
