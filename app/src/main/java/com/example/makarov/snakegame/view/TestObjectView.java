package com.example.makarov.snakegame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.initialized.FieldProvider;
/**
 * Класс объекта поля который будем отрисовывать
 * (пока это просто тестОбъект который будет двигаться)
 * Далее для каждого объекта поля будет свой класс и своя картинка
 */
public class TestObjectView implements View {

    private FieldObject mObject;
    private Bitmap mIcon;
    private Bitmap icon;
    private Paint mPaint;
    private FieldProvider mFieldProvider;
    /**
     * В констркторе сам объект поля
     * Контекст (часть экрана на которой отрисоваем)
     * провайдер поля
     * создаем кисточку
     * стрэйчим картинку из папки ресурсов
     */
    public TestObjectView(FieldObject object, Context context, FieldProvider fieldProvider){
        mObject = object;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFieldProvider = fieldProvider;

        mIcon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.object);
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
    /**
     * Вернуть объект передвижения
     */
    public FieldObject getObject() {
        return mObject;
    }
}
