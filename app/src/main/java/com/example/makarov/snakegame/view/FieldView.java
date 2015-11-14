package com.example.makarov.snakegame.view;

import com.example.makarov.snakegame.singleton.IconLoader;
import com.example.makarov.snakegame.FieldProvider;
import com.example.makarov.snakegame.field.MyField;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Класс отрисовываемого поля для игры
 */
public class FieldView {

    private MyField mField;
    private Bitmap icon;
    private Paint mPaint;
    private FieldProvider mFieldProvider;
    private IconLoader mIconLoader;

    /**
     * В конструктор контекст на котором будем отрисовывать
     * провайдер поля
     * создаем кисточку
     * получаем картинку из класса со всеми bitmap-ами
     */
    public FieldView(MyField field, FieldProvider fieldProvider, IconLoader iconLoader){
        mField = field;
        mFieldProvider = fieldProvider;
        mIconLoader = iconLoader;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        icon = mIconLoader.getIcon(IconLoader.TYPE_FIELD,
                mFieldProvider.getWidthScreen(), mFieldProvider.getHeightScreen());
    }

    /**
     * отрисовываем картинку на полный экран
     */
    public void draw(Canvas canvas) {
        //canvas.drawBitmap(icon, 0, 0, mPaint);
        canvas.drawColor(Color.WHITE);
    }

    /**
     * Вернуть объек поля(карту) на которой происходят передвижения объектов
     */
    public MyField getField() {
        return mField;
    }

}
