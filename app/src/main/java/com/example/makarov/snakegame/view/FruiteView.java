package com.example.makarov.snakegame.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.makarov.snakegame.IconLoader;
import com.example.makarov.snakegame.objects.FieldObject;
import com.example.makarov.snakegame.FieldProvider;

/**
 * Класс fruite который будем отрисовывать в игре
 */
public class FruiteView implements View {

    private FieldObject mObject;
    private Bitmap icon;
    private Paint mPaint;
    private FieldProvider mFieldProvider;
    private IconLoader mIconLoader;

    /**
     * В констркторе сам объект поля
     * провайдер поля
     * создаем кисточку
     * получаем картинку из класса со всеми bitmap-ами
     */
    public FruiteView(FieldObject object, FieldProvider fieldProvider, IconLoader iconLoader){
        mObject = object;
        mFieldProvider = fieldProvider;
        mIconLoader = iconLoader;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int width = (int)mFieldProvider.getWidthOneScreen();
        int height = (int)mFieldProvider.getHeightOneScreen();

        icon = mIconLoader.getIcon(IconLoader.TYPE_FRUITE, width, height);
    }

    /**
     * В методе, с помощью провайдера поля, узнаем на какие именно пиксели нужно отрисовать картинку
     * и отрисовываем картинку
     */
    @Override
    public void draw(Canvas canvas) {
        int x = (int)mFieldProvider.getScreenX(mObject.getX());
        int y = (int)mFieldProvider.getScreenY(mObject.getY());
        canvas.drawBitmap(icon, x, y, mPaint);
    }

    /**
     * Вернуть объект передвижения
     */
    public FieldObject getObject() {
        return mObject;
    }

}
