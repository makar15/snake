package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.direction.enumeration.Direction;
import com.example.makarov.snakegame.objects.TestObject;
import com.example.makarov.snakegame.field.ControllerField;
import com.example.makarov.snakegame.field.MyField;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс контроллера передвижения по кругу
 */
public class CircularMotionController extends Controller<TestObject> {

    private static final String TAG = "myLogs";

    private MyField mField;
    private ControllerField  mControllerField;
    private List<Direction> mListDirection = new ArrayList<>();

    /**
     * В лист направлений добавляем направления для движения по кругу(по часовой)
     */
    {
        mListDirection.add(Direction.UP);
        mListDirection.add(Direction.RIGHT);
        mListDirection.add(Direction.DOWN);
        mListDirection.add(Direction.LEFT);
    }

    /**
     * В конструктор объекты: поле, тестОбъект управления
     * Ставим начальное месторасположение на карте тестОбъекта
     */
    public CircularMotionController(MyField field, TestObject mFieldObject){
        super(mFieldObject);
        this.mField = field;
        mControllerField = new ControllerField(mField);

        mField.addObject(mObject, 0, 0);

    }

    /**
     * Метод передвижения объекта по кругу
     * За границами карты считаем что стенка и поворачиваем объект в этом случае
     */
    @Override
    public void nextMove() {

        //Log.d(TAG, "Объект на X :" + mObject.getX() + " на Y :" + mObject.getY());
        int nextX = (mObject.getX() + mObject.getMoving().getDirection().deltaX());
        int nextY = (mObject.getY() + mObject.getMoving().getDirection().deltaY());

        if ((nextX >= 0 && nextX < mField.getWidth()) && (nextY >= 0 && nextY < mField.getHeight())) {

            mControllerField.changeObjectLocation(mObject, nextX, nextY);
            //Log.d(TAG, "Объект на X :" + mObject.getX() + " на Y :" + mObject.getY());
        } else {
            turnAutomatic();
        }
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
     * метод поворота объекта на 90 градусов относительно текущего направления
     * Работа с листом, в котором находятся уже направления в нужном порядке
     */
    private void turnAutomatic(){
        int tempIndexDirection =
                mListDirection.indexOf(mObject.getMoving().getDirection());
        tempIndexDirection++;
        tempIndexDirection = tempIndexDirection % mListDirection.size();
        mObject.getMoving().setDirection(mListDirection.get(tempIndexDirection));

        //Log.d(TAG, "Поворот на X :" + mObject.getX() + " на Y :" + mObject.getY());
    }

}
