package com.example.makarov.snakegame.playingField;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * Класс поля(карты игры)
 */
public class MyField implements Field{

    public static final int CODE_EMPTY_CELL_ON_THE_MAP = 0;
    private Collection<FieldObject> objectsField;
    private int mField[][];
    private int mFieldWidth ;
    private int mFieldHeight ;
    /**
     * В конструктор масштаб карты по осям X, Y и очистка карты на нули
     */
    public MyField(int fieldX, int fieldY) {
        mFieldWidth = fieldX;
        mFieldHeight = fieldY;

        mField = new int[mFieldWidth][mFieldHeight];
        objectsField = new LinkedList<FieldObject>();
        clearField();
    }
    /**
     * Добавить объект на указанные координаты на поле
     */
    @Override
    public void addObject(FieldObject object, int newX, int newY) throws DuplicateObjectException {
        mField[newX][newY] = object.getCodeOnTheMap();
        addObjectFieldTheList(object);
        object.setX(newX);
        object.setY(newY);
    }
    /**
     * Добавить объект на свободное место на карте рандомом
     * В методе следующее происходит :
     * 1)Проверка, нету ли этого объекта в Collection<FieldObject> objectsField данной карты
     * 2)Находим свободное место и добавляем
     */
    @Override
    public void addRandomObject(FieldObject object) throws DuplicateObjectException {
        if(!getListObject().contains(object)) {
            boolean par = false;
            while (!par) {
                int x = (int) (Math.random() * getWidth());
                int y = (int) (Math.random() * getHeight());
                if (isEmptyField(x, y)) {
                    addObject(object, x, y);
                    par = true;
                }
            }
        }
    }
    /**
     * Изменить метоположение существующего обьекта на поле
     */
    @Override
    public void changeObjectLocation(FieldObject object, int newX, int newY) throws NotFoundObjectException {
        removeObject(object);
        addObject(object, newX, newY);
    }
    /**
     * Изменить метоположение существующего обьекта на поле с рассмотрением коллизии
     */
    @Override
    public void changeObjectLocationRandom(FieldObject object) throws NotFoundObjectException {
        removeObject(object);
        addRandomObject(object);
    }
    /**
     * очистить поле
     * выставить все нули(КОД свободной ячейки в матрице)
     */
    @Override
    public void clearField() {
        for (int i = 0; i < mFieldWidth; i++)
            for (int j = 0; j < mFieldHeight; j++) {
                mField[i][j] = CODE_EMPTY_CELL_ON_THE_MAP;
            }
        clearListObjectField();
    }
    /**
     *
     */
    @Override
    public void removeObject(FieldObject object) throws NotFoundObjectException {
        /**
         * проверка, существует ли этот объект в Collection<FieldObject> objectsField данной карты
         */
        mField[object.getX()][object.getY()] = CODE_EMPTY_CELL_ON_THE_MAP;
        removeObjectFieldTheList(object);
    }
    /**
     *
     */
    @Override
    public void removeObject(int x, int y) throws NotFoundObjectException {
        /**
         * проверка, существует ли этот объект в Collection<FieldObject> objectsField данной карты
         */
        mField[x][y] = CODE_EMPTY_CELL_ON_THE_MAP;
        removeObjectFieldTheList(getFieldObject(x, y));
    }
    /**
     * Вернуть список объектов находящихся на карте
     */
    @Override
    public Collection<FieldObject> getListObject() {
        return objectsField;
    }
    /**
     * Вернуть объект поля
     */
    @Override
    public FieldObject getFieldObject(int x, int y){
        Iterator<FieldObject> iter = objectsField.iterator();
        while (iter.hasNext()) {
            FieldObject tempObject = iter.next();
            if(tempObject.getX() == x && tempObject.getY() == y){
                return tempObject;
            }
        }
        return  null;
    }
    /**
     * Проверить, свободная ли клетка поля
     */
    @Override
    public boolean isEmptyField(int x, int y) {
        if(mField[x][y] == CODE_EMPTY_CELL_ON_THE_MAP) return true;
        return false;
    }
    /**
     * Вернуть Код поля по позиции
     */
    @Override
    public int getCodeFieldByPosition(int x, int y){
        return mField[x][y];
    }
    /**
     * Вернуть ширину поля
     */
    @Override
    public int getWidth() {
        return mFieldWidth;
    }
    /**
     * Вернуть высоту поля
     */
    @Override
    public int getHeight() {
        return mFieldHeight;
    }
    /**
     * Вернуть Код свободной ячейки поля
     */
    @Override
    public int getCODE_ON_THE_MAP() {
        return CODE_EMPTY_CELL_ON_THE_MAP;
    }
    /**
     * Добавить объект в список объектов поля
     */
    public void addObjectFieldTheList(FieldObject object){
        objectsField.add(object);
    }
    /**
     * Удалить объект из списка объектов поля
     */
    public void removeObjectFieldTheList(FieldObject object){
        objectsField.remove(object);
    }
    /**
     * Очистить список объектов поля
     */
    public void clearListObjectField(){
        objectsField.clear();
    }

}
