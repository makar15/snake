package com.example.makarov.snakegame.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.makarov.snakegame.initialized.FieldProvider;
import com.example.makarov.snakegame.initialized.IconLoader;
import com.example.makarov.snakegame.objects.FieldObject;

/**
 *
 */
public class BombView implements View {

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
    public BombView(FieldObject object, FieldProvider fieldProvider, IconLoader iconLoader){
        mObject = object;
        mFieldProvider = fieldProvider;
        mIconLoader = iconLoader;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        icon = mIconLoader.getIcon(IconLoader.TYPE_BOMB,
                mFieldProvider.getWidthOneScreen(), mFieldProvider.getHeightOneScreen());
    }

    /**
     * В методе, с помощью провайдера поля, узнаем на какие именно пиксели нужно отрисовать картинку
     * и отрисовываем картинку
     */
    @Override
    public void draw(Canvas canvas) {
        int x = mFieldProvider.getScreenX(mObject.getX());
        int y = mFieldProvider.getScreenY(mObject.getY());
        canvas.drawBitmap(icon, x, y, mPaint);
    }

    /**
     * Вернуть объект передвижения
     */
    public FieldObject getObject() {
        return mObject;
    }

}
