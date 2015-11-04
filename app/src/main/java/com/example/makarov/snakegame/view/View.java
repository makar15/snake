package com.example.makarov.snakegame.view;

import android.graphics.Canvas;
import com.example.makarov.snakegame.objects.FieldObject;

/**
 * Интерфейс элемента который отрисовываем
 */
public interface View {

    /**
     * Метод в котором отрисовываем
     */
    void draw(Canvas canvas);

    /**
     * Вернуть объект передвижения
     */
    FieldObject getObject();

}
