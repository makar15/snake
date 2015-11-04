package com.example.makarov.snakegame.controllers;

import android.view.MotionEvent;
import android.view.View;
import com.example.makarov.snakegame.direction.enumeration.Direction;
import com.example.makarov.snakegame.objects.TestObject;
import com.example.makarov.snakegame.initialized.FieldProvider;
import com.example.makarov.snakegame.field.ControllerField;
import com.example.makarov.snakegame.field.MyField;

/**
 * Класс контроллера движения с тач касаниями по экрану
 */
public class ControllerTouchResponse extends Controller<TestObject> {

    private static final String TAG = "myLogs";

    private final View mGameSnake;
    private final FieldProvider mFieldProvider;
    private final MyField mField;
    private final ControllerField mControllerField;

    /**
     * В конструктор объекты: поле, тестОбъект управления, View , Провайдер поля
     */
    public ControllerTouchResponse(MyField field, TestObject mFieldObject,
                                    View gameSnake, FieldProvider fieldProvider){
        super(mFieldObject);
        mField = field;
        mControllerField = new ControllerField(mField);
        mGameSnake = gameSnake;
        mFieldProvider = fieldProvider;

        /**
         * При тапах по экрану
         */
        mGameSnake.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                turnOnTheTouch(event);
                return false;
            }
        });
    }

    /**
     * Метод передвижения объекта с тапоми по экрану
     */
    @Override
    public void nextMove() {

        //ИЗМЕНИТЬ
        //В класс который этим будет заниматься
        int nextX = (mObject.getX() + mObject.getMoving().getDirection().deltaX());
        int nextY = (mObject.getY() + mObject.getMoving().getDirection().deltaY());

        mControllerField.changeObjectLocation(mObject, nextX, nextY);
    }

    /**
     * Вернуть объект над которым управляет данный контроллер
     */
    @Override
    public TestObject getObject() {
        return this.mObject;
    }

    /**
     * Вернуть поле на котором происходит передвижение объекта
     */
    @Override
    public MyField getField() {
        return mField;
    }

    /**
     * Метод решающий изменение направления объекта, в зависимости от точки тапа по экрану
     */
    private void turnOnTheTouch(MotionEvent event){
        switch(mObject.getMoving().getDirection()) {
            case UP:
                if(event.getX() > mFieldProvider.getScreenX
                        (mObject.getX()) + (mFieldProvider.getWidthOneScreen()/2)){
                    mObject.getMoving().setDirection(Direction.RIGHT);
                } else{
                    mObject.getMoving().setDirection(Direction.LEFT);
                }
                break;
            case DOWN:
                if(event.getX() > mFieldProvider.getScreenX
                        (mObject.getX()) + (mFieldProvider.getWidthOneScreen()/2)){
                    mObject.getMoving().setDirection(Direction.RIGHT);
                } else{
                    mObject.getMoving().setDirection(Direction.LEFT);
                }
                break;
            case RIGHT:
                if(event.getY() > mFieldProvider.getScreenX
                        (mObject.getY()) + (mFieldProvider.getWidthOneScreen()/2)){
                    mObject.getMoving().setDirection(Direction.DOWN);
                } else{
                    mObject.getMoving().setDirection(Direction.UP);
                }
                break;
            case LEFT:
                if(event.getY() > mFieldProvider.getScreenX
                        (mObject.getY()) + (mFieldProvider.getWidthOneScreen()/2)){
                    mObject.getMoving().setDirection(Direction.DOWN);
                } else{
                    mObject.getMoving().setDirection(Direction.UP);
                }
                break;
            case UNMOVING:
                /*
                Переписать
                Что бы когда объект просто стоял, можно было его не только в два направления послать
                Сделать что бы сравнивал разницу по иксу и игрику и сравнивал
                 */
                if(event.getX() > mFieldProvider.getScreenX
                        (mObject.getX()) + (mFieldProvider.getWidthOneScreen()/2)){
                    mObject.getMoving().setDirection(Direction.RIGHT);
                } else{
                    mObject.getMoving().setDirection(Direction.LEFT);
                }
                break;
        }
    }
}
