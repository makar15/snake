package com.example.makarov.snakegame;

import android.view.ScaleGestureDetector;
/**
 * Пока НЕ придумал
 * Класс в котором запоминаем и записываем в коллекцию, нажатие пользователя по экрану
 * еще должен быть метод возврата из коллекции всех тапов по экрану
 */
public class Input extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    @Override
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        int focusX = (int)scaleGestureDetector.getFocusX();
        int focusY = (int)scaleGestureDetector.getFocusY();
        return true;
    }
}
