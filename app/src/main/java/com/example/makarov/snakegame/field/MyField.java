package com.example.makarov.snakegame.field;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.objects.FieldObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Класс поля(карты игры)
 */
public class MyField {

    public static final int CODE_EMPTY_CELL_ON_THE_MAP = 0;
    private Collection<FieldObject> objectsField;
    private int mField[][];
    private int mFieldWidth ;
    private int mFieldHeight ;

    /**
     * В конструктор масштаб карты по осям X, Y
     * Инициализируем матрицу игры и список объектов на карте,
     * Очищаем карту на нули
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
    public void addObject(FieldObject object, int newX, int newY) throws DuplicateObjectException {
        if (existenceCellField(newX, newY)) {
            mField[newX][newY] = object.getCode();
            addObjectFieldTheList(object);
            object.setXY(newX, newY);
        } else {
            addRandomObject(object);
        }
    }

    /**
     * Добавить объект на свободное место на карте рандомом
     * В методе следующее происходит :
     * 1)Проверка, нету ли этого объекта в списке объектов карты
     * 2)Находим свободное место и добавляем
     */
    public void addRandomObject(FieldObject object) throws DuplicateObjectException {
        if(!getListObject().contains(object)) {

            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());

            while (!isEmptyField(x, y)) {
                x = (int) (Math.random() * getWidth());
                y = (int) (Math.random() * getHeight());
            }

            addObject(object, x, y);
        }
    }

    /**
     * Изменить местоположение существующего обьекта на поле
     */
    public void changeObjectLocation(FieldObject object, int newX, int newY)
            throws NotFoundObjectException {
        if(existenceCellField(newX, newY)) {
            clearCellField(object.getX(), object.getY());
            mField[newX][newY] = object.getCode();
            object.setXY(newX, newY);
        }else{
            changeObjectLocationRandom(object);
        }
    }

    /**
     * Изменить местоположение существующего обьекта на поле, в рандомную свободную ячейку
     */
    public void changeObjectLocationRandom(FieldObject object) throws NotFoundObjectException {
        if(getListObject().contains(object)) {
            boolean par = false;
            while (!par) {
                int x = (int) (Math.random() * getWidth());
                int y = (int) (Math.random() * getHeight());
                if (isEmptyField(x, y)) {
                    changeObjectLocation(object, x, y);
                    par = true;
                }
            }
        }
    }

    /**
     * очистить поле
     * выставить все нули(КОД свободной ячейки в матрице)
     */
    public void clearField() {
        for (int i = 0; i < mFieldWidth; i++)
            for (int j = 0; j < mFieldHeight; j++) {
                mField[i][j] = CODE_EMPTY_CELL_ON_THE_MAP;
            }
        clearListObjectField();
    }

    /**
     * очистить ячейку поля
     */
    public void clearCellField(int x, int y) {
        if(existenceCellField(x, y)) {
            mField[x][y] = CODE_EMPTY_CELL_ON_THE_MAP;
        }
    }

    /**
     * Удаление объекта с поля
     */
    public void removeObject(FieldObject object) throws NotFoundObjectException {
        mField[object.getX()][object.getY()] = CODE_EMPTY_CELL_ON_THE_MAP;
        removeObjectFieldTheList(object);
    }

    /**
     * Проверить, свободная ли клетка поля
     */
    public boolean isEmptyField(int x, int y) {
        if(existenceCellField(x, y)) {
            if (mField[x][y] == CODE_EMPTY_CELL_ON_THE_MAP) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Проверить, существует ли ячейка поля
     */
    public boolean existenceCellField(int x, int y){
        if((x >= 0 && x < mFieldWidth) && (y >= 0 && y < mFieldHeight)){
            return true;
        }
        return false;
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

    /**
     * Вернуть объект поля
     */
    public FieldObject getFieldObject(int x, int y){
        if(existenceCellField(x, y)) {
            Iterator<FieldObject> iter = objectsField.iterator();
            while (iter.hasNext()) {
                FieldObject tempObject = iter.next();
                if (tempObject.getX() == x && tempObject.getY() == y) {
                    return tempObject;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Вернуть список объектов находящихся на карте
     */
    public Collection<FieldObject> getListObject() {
        return objectsField;
    }

    /**
     * Вернуть Код поля по позиции
     */
    public int getCodeFieldByPosition(int x, int y){
        return mField[x][y];
    }

    /**
     * Вернуть Код свободной ячейки поля
     */
    public int getCODE_ON_THE_MAP() {
        return CODE_EMPTY_CELL_ON_THE_MAP;
    }

    /**
     * Вернуть ширину поля
     */
    public int getWidth() {
        return mFieldWidth;
    }

    /**
     * Вернуть высоту поля
     */
    public int getHeight() {
        return mFieldHeight;
    }

}
