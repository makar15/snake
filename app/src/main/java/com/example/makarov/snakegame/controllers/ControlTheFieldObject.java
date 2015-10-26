package com.example.makarov.snakegame.controllers;

import android.util.Log;
import com.example.makarov.snakegame.enumeration.Direction;
import com.example.makarov.snakegame.fieldObjects.TestObject;
import com.example.makarov.snakegame.playingField.Field;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс контроллера тестОбъекта
 */
public class ControlTheFieldObject extends Controller<TestObject> {

    private static final String TAG = "myLogs";

    private Field mField;
    private List<Direction> mListDirection = new ArrayList<>();
    /**
     * В лист направлений добавляем для движения по кругу(по часовой)
     */
    {
        mListDirection.add(Direction.UP);
        mListDirection.add(Direction.RIGHT);
        mListDirection.add(Direction.DOWN);
        mListDirection.add(Direction.LEFT);
    }
    /**
     * В конструктор объекты: поле, тестОбъект управления, контроллер поля
     * Ставим начальное месторасположение на карте тестОбъекта
     */
    public ControlTheFieldObject(Field field,
                                 TestObject mFieldObject){
        super(mFieldObject);
        this.mField = field;

        mField.addObject(mFieldObject, 0, 0);
    }
    /**
     * Метод передвижения объекта по кругу
     * За границами карты считаем что стенка и поворачиваем объект в этом случае
     */
    @Override
    public void nextMove() {
        Log.d(TAG, "Объект на X :" + mObject.getX() + " на Y :" + mObject.getY());

        int nextX = (mObject.getX() + mObject.getDirectionOfMotion().getDirection().deltaX());
        int nextY = (mObject.getY() + mObject.getDirectionOfMotion().getDirection().deltaY());

        if ((nextX >= 0 && nextX < mField.getWidth()) && (nextY >= 0 && nextY < mField.getHeight())) {
            if (mField.isEmptyField(nextX, nextY)) {
                mField.changeObjectLocation(mObject, nextX, nextY);

                Log.d(TAG, "Объект на X :" + mObject.getX() + " на Y :" + mObject.getY());
            } else {
                turnObjectField();
            }
        } else {
            turnObjectField();
        }
        nextMove();
    }
    /**
     * Вернуть объект над которым управляет данный контроллер
     */
    @Override
    public TestObject getObject() {
        return this.mObject;
    }
    /**
     * метод поворота объекта на 90 градусов относительно текущего направления
     * Работа с листом в котором лежат уже направления внужном порядке
     */
    private void turnObjectField(){
        int tempIndexDirection =
                mListDirection.indexOf(mObject.getDirectionOfMotion().getDirection());
        tempIndexDirection++;
        tempIndexDirection = tempIndexDirection % mListDirection.size();
        mObject.getDirectionOfMotion().setDirection(mListDirection.get(tempIndexDirection));

        Log.d(TAG, "Поворот на X :" + mObject.getX() + " на Y :" + mObject.getY());
    }

}
