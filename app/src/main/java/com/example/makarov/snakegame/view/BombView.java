package com.example.makarov.snakegame.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.makarov.snakegame.FieldProvider;
import com.example.makarov.snakegame.singleton.IconLoader;
import com.example.makarov.snakegame.objects.FieldObject;

/**
 * Класс Bomb которую будем отрисовывать в игре
 */
public class BombView implements View {

    private final FieldObject mObject;
    private final Paint mPaint;
    private final FieldProvider mFieldProvider;
    private IconLoader mIconLoader;
    private Bitmap icon;

    /**
     * В конструкторе: сам объект поля;
     * провайдер поля;
     * создаем кисточку;
     * получаем картинку из класса со всеми bitmap-ами.
     */
    public BombView(FieldObject object, FieldProvider fieldProvider, IconLoader iconLoader){
        mObject = object;
        mFieldProvider = fieldProvider;
        mIconLoader = iconLoader;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int width = (int)mFieldProvider.getWidthOneScreen();
        int height = (int)mFieldProvider.getHeightOneScreen();

        icon = mIconLoader.getIcon(IconLoader.TYPE_BOMB, width, height);
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
