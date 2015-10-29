package com.example.makarov.snakegame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
/**
 *
 */
public class FruiteView implements View {

    private FieldObject mObject;
    private Bitmap mIcon;
    private Bitmap icon;
    private Paint mPaint;
    private FieldProvider mFieldProvider;
    /**
     * В конструкторе сам объект поля
     * Контекст (часть экрана на которой отрисоваем)
     * провайдер поля
     * создаем кисточку
     * стрэйчим картинку из папки ресурсов
     */
    public FruiteView(FieldObject object, Context context, FieldProvider fieldProvider){
        mObject = object;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFieldProvider = fieldProvider;

        mIcon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.fruite);
        icon = Bitmap.createScaledBitmap
                (mIcon, mFieldProvider.getWidthOne(), mFieldProvider.getHeightOne(), true);
    }
    /**
     * В методе с помощью провайдера поля узнаем на какие именно пиксели нужно отрисовать картинку,
     * и отрисовываем картинку
     */
    @Override
    public void draw(Canvas canvas) {
        int x = mFieldProvider.getScreenX(mObject.getX());
        int y = mFieldProvider.getScreenY(mObject.getY());
        canvas.drawBitmap(icon, x, y, mPaint);
    }
}
