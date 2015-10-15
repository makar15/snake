package com.example.makarov.snakegame.playingField;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import java.util.Collection;
import java.util.LinkedList;

public class MyField implements Field{
    /**
     * Класс поля(карты игры)
     * в конструктор масштаб карты по осям X, Y и очистка карты на нули
     * сет методы добавления объектов на координаты, а так же гет методы
     */
    public static final int CODE_EMPTY_CELL_ON_THE_MAP = 0;
    private Collection<FieldObject> objectsField;
    private int mField[][];
    private int mFieldWidth ;
    private int mFieldHeight ;

    public MyField(int fieldX, int fieldY) {
        mFieldWidth = fieldX;
        mFieldHeight = fieldY;

        mField = new int[mFieldWidth][mFieldHeight];
        objectsField = new LinkedList<FieldObject>();
        clearField();
    }

    @Override
    public void addObject(FieldObject object, int x, int y) throws DuplicateObjectException {
        mField[x][y] = object.getCodeOnTheMap();
        addObjectFieldTheList(object);
        object.setX(x);
        object.setY(y);
    }

    @Override
    public void changeObjectLocation(FieldObject object, int x, int y) throws NotFoundObjectException {

    }
    /**
     * очищает поле выстваляя все нули(КОД свободной ячейки в матрице)
     */
    @Override
    public void clearField() {
        for (int i = 0; i < mFieldWidth; i++)
            for (int j = 0; j < mFieldHeight; j++) {
                mField[i][j] = CODE_EMPTY_CELL_ON_THE_MAP;
            }
        clearListObjectField();
    }

    @Override
    public void removeObject(FieldObject object) throws NotFoundObjectException {
    /**
     * проверка, существует ли этот объект в Collection<FieldObject> objectsField данной карты
     */
        mField[object.getX()][object.getY()] = CODE_EMPTY_CELL_ON_THE_MAP;
        removeObjectFieldTheList(object);
    }

    @Override
    public Collection<FieldObject> getListObject() {
        return objectsField;
    }

    @Override
    public boolean isEmptyField(int x, int y) {
        if(mField[x][y] == CODE_EMPTY_CELL_ON_THE_MAP) return true;
        return false;
    }

    @Override
    public int getCodeFieldByPosition(int x, int y){
        return mField[x][y];
    }

    @Override
    public int getWidth() {
        return mFieldWidth;
    }

    @Override
    public int getHeight() {
        return mFieldHeight;
    }

    @Override
    public int getCODE_ON_THE_MAP() {
        return CODE_EMPTY_CELL_ON_THE_MAP;
    }

    public void addObjectFieldTheList(FieldObject object){
        objectsField.add(object);
    }

    public void removeObjectFieldTheList(FieldObject object){
        objectsField.remove(object);
    }

    public void clearListObjectField(){
        objectsField.clear();
    }
    /**
     * 6 Замутить обычный объект и контроллер к нему для движения по карте
     * Задание такое.
     * Написать простой контроллер для объекта.
     * Хочу чтобы он двигался прямо, если встречал препятствие то поворачивал направо
     * На нем будем тестировать отрисовку объектов
     * Объект это fieldObject
     */
}
