package com.example.makarov.snakegame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.makarov.snakegame.R;
/**
 * Класс отрисовываемого поля для игры
 */
public class FieldView implements View {

    private Bitmap mIcon;
    private Paint mPaint;
    private FieldProvider mFieldProvider;
    /**
     * В конструктор контекст на котором будем отрисовывать
     * провайдер поля
     * создаем кисточку
     * стрэйчим картинку из папки ресурсов
     */
    public FieldView(Context context, FieldProvider fieldProvider){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mFieldProvider = fieldProvider;

        mIcon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.field);
    }
    /**
     * отрисовываем картинку на полный экран
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap
                (mIcon, mFieldProvider.getWightScreen(), mFieldProvider.getHeightScreen(), mPaint);
    }
}
