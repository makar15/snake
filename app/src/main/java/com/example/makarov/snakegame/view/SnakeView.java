package com.example.makarov.snakegame.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.makarov.snakegame.objects.ComponentSnake;
import com.example.makarov.snakegame.objects.FieldObject;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.initialized.FieldProvider;
import com.example.makarov.snakegame.initialized.IconLoader;
import java.util.List;

/**
 * Класс snake который будем отрисовывать в игре
 */
public class SnakeView implements View {

    private Snake mObject;
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
    public SnakeView(Snake object, FieldProvider fieldProvider, IconLoader iconLoader){
        mObject = object;
        mFieldProvider = fieldProvider;
        mIconLoader = iconLoader;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        icon = mIconLoader.getIcon(IconLoader.TYPE_SNAKE,
                mFieldProvider.getWidthOneScreen(), mFieldProvider.getHeightOneScreen());
    }

    /**
     * В методе, пролистывая список компонентов змейки, с помощью провайдера поля узнаем
     * ,на какие именно пиксели нужно отрисовать каждую компаненту змейки
     * и отрисовываем картинку
     */
    @Override
    public void draw(Canvas canvas) {
        List<ComponentSnake> list = mObject.getComponents();
        for(int i = list.size() - 1; i >= 0; i--){
            int x = mFieldProvider.getScreenX(list.get(i).getX());
            int y = mFieldProvider.getScreenY(list.get(i).getY());
            canvas.drawBitmap(icon, x, y, mPaint);
        }
    }

    /**
     * Вернуть объект передвижения
     */
    public FieldObject getObject() {
        return mObject;
    }
}
