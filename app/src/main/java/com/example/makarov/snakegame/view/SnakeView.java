package com.example.makarov.snakegame.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.example.makarov.snakegame.direction.enumeration.Direction;
import com.example.makarov.snakegame.objects.ComponentSnake;
import com.example.makarov.snakegame.objects.FieldObject;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.FieldProvider;
import com.example.makarov.snakegame.IconLoader;
import java.util.List;

/**
 * Класс snake который будем отрисовывать в игре
 *
 * С прорисовкой красивой змейки в игре пока не все хорошо, над этим работаю
 * Трабла с прорисовкой всех компонент после поворотов змейки
 */
public class SnakeView implements View {

    private Snake mObject;
    private Bitmap iconHeadUp;
    private Bitmap iconHeadRight;
    private Bitmap iconHeadDown;
    private Bitmap iconHeadLeft;
    private Bitmap iconTailUp;
    private Bitmap iconTailRight;
    private Bitmap iconTailDown;
    private Bitmap iconTailLeft;
    private Bitmap iconTrunkVertical;
    private Bitmap iconTrunkHorizontal;
    private Bitmap iconTurnDr;
    private Bitmap iconTurnDl;
    private Bitmap iconTurnUl;
    private Bitmap iconTurnUr;
    private Paint mPaint;
    private FieldProvider mFieldProvider;
    private IconLoader mIconLoader;

    /**
     * В конструкторе сам объект поля
     * провайдер поля
     * создаем кисточку
     * получаем картинку из класса со всеми bitmap-ами
     */
    public SnakeView(Snake object, FieldProvider fieldProvider, IconLoader iconLoader){
        mObject = object;
        mFieldProvider = fieldProvider;
        mIconLoader = iconLoader;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int width = (int)mFieldProvider.getWidthOneScreen();
        int height = (int)mFieldProvider.getHeightOneScreen();

        /*
        Картинки : голова, хвост, туловище, туловище в поворотах
         */
        iconHeadUp = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_HEAD, width, height);
        iconTailUp = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_TAIL, width, height);
        iconTrunkVertical = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_TRUNK_VERTICAL, width, height);
        iconTrunkHorizontal = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_TRUNK_HORIZONTAL, width, height);
        iconTurnDr = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_TURN_DOWN_RIGHT, width, height);
        iconTurnDl = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_TURN_DOWN_LEFT, width, height);
        iconTurnUl = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_TURN_UP_LEFT, width, height);
        iconTurnUr = mIconLoader.getIcon(IconLoader.TYPE_SNAKE_TURN_UP_RIGHT, width, height);

        /*
        Картинки головы и хвоста для различных направлений
         */
        Matrix matrix = new Matrix();

        matrix.setRotate(90, mFieldProvider.getWidthOneScreen()/2,
                mFieldProvider.getHeightOneScreen()/2);
        iconHeadRight = Bitmap.createBitmap(iconHeadUp, 0, 0, width, height, matrix, true);
        iconTailRight = Bitmap.createBitmap(iconTailUp, 0, 0, width, height, matrix, true);

        matrix.setRotate(180, mFieldProvider.getWidthOneScreen()/2,
                mFieldProvider.getHeightOneScreen()/2);
        iconHeadDown = Bitmap.createBitmap(iconHeadUp, 0, 0, width, height, matrix, true);
        iconTailDown = Bitmap.createBitmap(iconTailUp, 0, 0, width, height, matrix, true);

        matrix.setRotate(270, mFieldProvider.getWidthOneScreen()/2,
                mFieldProvider.getHeightOneScreen()/2);
        iconHeadLeft = Bitmap.createBitmap(iconHeadUp, 0, 0, width, height, matrix, true);
        iconTailLeft = Bitmap.createBitmap(iconTailUp, 0, 0, width, height, matrix, true);
    }

    /**
     * В методе, пролистывая список компонентов змейки, с помощью провайдера поля узнаем
     * ,на какие именно пиксели нужно отрисовать каждую компаненту змейки
     * и отрисовываем картинку
     */
    @Override
    public void draw(Canvas canvas) {
        List<ComponentSnake> list = mObject.getComponents();

        int head = list.size() - 1;
        int xHead = (int)mFieldProvider.getScreenX(list.get(head).getX());
        int yHead = (int)mFieldProvider.getScreenY(list.get(head).getY());
        switch (mObject.getMoving().getDirection()){
            case UP:
                canvas.drawBitmap(iconHeadUp, xHead, yHead, mPaint);
                break;
            case RIGHT:
                canvas.drawBitmap(iconHeadRight, xHead, yHead, mPaint);
                break;
            case DOWN:
                canvas.drawBitmap(iconHeadDown, xHead, yHead, mPaint);
                break;
            case LEFT:
                canvas.drawBitmap(iconHeadLeft, xHead, yHead, mPaint);
                break;
        }

        for(int i = list.size() - 2; i > 0; i--){
            int x = (int)mFieldProvider.getScreenX(list.get(i).getX());
            int y = (int)mFieldProvider.getScreenY(list.get(i).getY());
            if(mObject.getMoving().getDirection() == Direction.UP ||
                    mObject.getMoving().getDirection() == Direction.DOWN){
                canvas.drawBitmap(iconTrunkVertical, x, y, mPaint);
            }else{
                canvas.drawBitmap(iconTrunkHorizontal, x, y, mPaint);
            }
        }

        int xTail = (int)mFieldProvider.getScreenX(list.get(0).getX());
        int yTail = (int)mFieldProvider.getScreenY(list.get(0).getY());
        switch (mObject.getMoving().getDirection()){
            case UP:
                canvas.drawBitmap(iconTailUp, xTail, yTail, mPaint);
                break;
            case RIGHT:
                canvas.drawBitmap(iconTailRight, xTail, yTail, mPaint);
                break;
            case DOWN:
                canvas.drawBitmap(iconTailDown, xTail, yTail, mPaint);
                break;
            case LEFT:
                canvas.drawBitmap(iconTailLeft, xTail, yTail, mPaint);
                break;
        }
    }

    /**
     * Вернуть объект передвижения
     */
    public FieldObject getObject() {
        return mObject;
    }
}
