package com.example.makarov.snakegame.view;

import com.example.makarov.snakegame.playingField.Field;
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

    private Field mField;
    private Bitmap mIcon;
    private Paint mPaint;
    private FieldProvider mFieldProvider;
    /**
     * В конструктор контекст на котором будем отрисовывать
     * провайдер поля
     * создаем кисточку
     * стрэйчим картинку из папки ресурсов
     */
    public FieldView(Field field, Context context, FieldProvider fieldProvider){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mField = field;
        mFieldProvider = fieldProvider;

        mIcon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.fieldnew);
    }
    /**
     * отрисовываем картинку на полный экран
     */
    @Override
    public void draw(Canvas canvas) {
        Bitmap icon = Bitmap.createScaledBitmap
                (mIcon, mFieldProvider.getWightScreen(), mFieldProvider.getHeightScreen(), true);
        canvas.drawBitmap(icon, 0, 0, mPaint);
    }
}
