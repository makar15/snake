package com.example.makarov.snakegame.controllers;

import android.util.Log;
import com.example.makarov.snakegame.enumeration.Direction;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.TestObjectField;
import com.example.makarov.snakegame.playingField.ControllerField;
import com.example.makarov.snakegame.playingField.Field;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс контроллера тестОбъекта
 */
public class ControlTheFieldObject implements ObjectController {

    private static final String TAG = "myLogs";

    private TestObjectField mTestObj;
    private ControllerField mControllerField;
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
                                 FieldObject mFieldObject, ControllerField controllerField){
        this.mField = field;
        this.mTestObj = (TestObjectField) mFieldObject;
        this.mControllerField = controllerField;

        changeLocation(0, 0);

        Log.d(TAG, "Объект на X :" + mTestObj.getX() + " на Y :" + mTestObj.getY());
    }
    /**
     * Метод передвижения объекта по кругу
     * За границами карты считаем что стенка и поворачиваем объект в этом случае
     */
    @Override
    public void nextMove() {

        int nextX = (mTestObj.getX() + mTestObj.getDirectionOfMotion().getDirection().deltaX());
        int nextY = (mTestObj.getY() + mTestObj.getDirectionOfMotion().getDirection().deltaY());

        if ((nextX >= 0 && nextX < mField.getWidth()) && (nextY >= 0 && nextY < mField.getHeight())) {

            if (mField.isEmptyField(nextX, nextY)) {
                mField.changeObjectLocation(mTestObj, nextX, nextY);

                Log.d(TAG, "Объект на X :" + mTestObj.getX() + " на Y :" + mTestObj.getY());
            } else {
                turnObjectField();
            }
        } else {
            turnObjectField();
        }

    }
    /**
     * Вернуть объект над которым управляет данный контроллер
     */
    @Override
    public FieldObject getObject() {
        return this.mTestObj;
    }
    /**
     * Задаем начальное местоположение объекта
     *
     * тут конечно можно прибавлять 1 к x и снова проверять не свободна ли эта клетка,
     * но легче добавить сразу на рандомную и главное свободную ячейку поля
     * Для тестирования нужно будем запросить вывести на экран координаты в классе теста,
     * что бы знать откуда объект будет начинать двигаться
     */
    private void changeLocation(int x, int y){
        if(mField.isEmptyField(x, y)){
            mField.addObject(mTestObj, x, y);
        }else{
            mControllerField.addRandomObject(mTestObj);
        }
    }
    /**
     * метод поворота объекта на 90 градусов относительно текущего направления
     * Работа с листом в котором лежат уже направления внужном порядке
     */
    private void turnObjectField(){
        int tempIndexDirection =
                mListDirection.indexOf(mTestObj.getDirectionOfMotion().getDirection());
        tempIndexDirection++;
        tempIndexDirection = tempIndexDirection % mListDirection.size();
        mTestObj.getDirectionOfMotion().setDirection(mListDirection.get(tempIndexDirection));

        Log.d(TAG, "Поворот на X :" + mTestObj.getX() + " на Y :" + mTestObj.getY());
    }

}
