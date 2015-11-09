package com.example.makarov.snakegame.field;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.objects.FieldObject;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.handler.ChoiceCollision;

/**
 * Класс упраления полем
 * Классу ChoiceCollision передаёт объекты столкновений
 * А так же удаляет, добавляет, меняет позицию объектов или очищает поле
 */
public class ControllerField  {

    private final MyField mField;
    private ChoiceCollision mChoiceCollision;

    /**
     * В конструктор поле на котором будем проводить операции
     * Инициализируем объект определяющий между кем столкновение
     */
    public ControllerField(MyField field){
        this.mField = field;
        mChoiceCollision = new ChoiceCollision(mField);
    }

    /**
     * Добавить объект на указанные координаты на поле с рассмотрением коллизии
     * В методе следующее происходит :
     * 1)проверка, нету ли этого объекта в списке объектов данной карты
     * 2)если ячейка поля существует , тогда :
     *   3)если место куда пытаемся добавить пустое, тогда добавляем
     *   4)если объект тестОбъект, тогда обработчик столкновений обрабатывает уже всё
     *   5)иначе добавляем этот объект на другое свободное место
     * 6)Иначе добавляем этот объект на другое свободное место
     */
    public void addObject(FieldObject objectStress, int newX, int newY) throws DuplicateObjectException {
        if(!mField.getListObject().contains(objectStress)) {
            if(mField.existenceCellField(newX, newY)) {
                if (mField.isEmptyField(newX, newY)) {
                    mField.addObject(objectStress, newX, newY);
                } else if (objectStress.getCode() == Snake.CODE_SNAKE_ON_THE_MAP) {
                    FieldObject objectCollisions = mField.getFieldObject(newX, newY);
                    mChoiceCollision.solutionCollision(objectStress, objectCollisions);
                } else {
                    addRandomObject(objectStress);
                }
            }else{
                addRandomObject(objectStress);
            }
        }
    }

    /**
     * Добавить объект на свободное место на карте рандомом
     * В методе следующее происходит :
     * 1)Проверка, нету ли этого объекта в Collection<FieldObject> objectsField данной карты
     * 2)Находим свободное место и добавляем
     */
    public void addRandomObject(FieldObject object) throws DuplicateObjectException {
        if(!mField.getListObject().contains(object)) {
            boolean par = false;
            while (!par) {
                int x = (int) (Math.random() * mField.getWidth());
                int y = (int) (Math.random() * mField.getHeight());
                if (mField.isEmptyField(x, y)) {
                    addObject(object, x, y);
                    par = true;
                }
            }
        }
    }

    /**
     * Изменить местоположение существующего обьекта на поле с рассмотрением коллизии
     * В методе следующее происходит :
     * 1)если ячейка поля существует , тогда :
     *   2)если место на которое пытаемся переместить пустое, тогда перемещаем
     *   3)если объект тестОбъект, тогда обработчик столкновений обрабатывает уже всё
     *   4)иначе перемещаем этот объект на другое свободное место
     * 5)иначе коллизия границ поля решает куда переместить
     */
    public void changeObjectLocation(FieldObject object, int newX, int newY) throws NotFoundObjectException {
        if(mField.existenceCellField(newX, newY)) {
            if (mField.isEmptyField(newX, newY)) {
                mField.changeObjectLocation(object, newX, newY);
            } else if (object.getCode() == Snake.CODE_SNAKE_ON_THE_MAP) {
                FieldObject objectCollisions = mField.getFieldObject(newX, newY);
                mChoiceCollision.solutionCollision(object, objectCollisions);
            } else {
                mField.changeObjectLocationRandom(object);
            }
        }
        else {
            collisionBoundaryField(object, newX, newY);
        }
    }

    /**
     * В методе смотри с какой стороны поля объект вышел за границу поля,
     * и перемешает его с ровно противоположной стороны
     */
    private void collisionBoundaryField(FieldObject object, int x, int y){
        if(!existenceCellWidthRight(x)){
            changeObjectLocation(object, 0 , y);
        } else if (!existenceCellWidthLeft(x)){
            changeObjectLocation(object, mField.getWidth() - 1, y);
        } else if (!existenceCellHeightDown(y)){
            changeObjectLocation(object, x, 0);
        } else if (!existenceCellHeightUp(y)){
            changeObjectLocation(object, x, mField.getHeight() - 1);
        }
    }

    /**
     * Проверка пересечения правой границы поля
     */
    public boolean existenceCellWidthRight(int x){
        if(x < mField.getWidth()){
            return true;
        }
        return false;
    }

    /**
     * Проверка пересечения левой границы поля
     */
    public boolean existenceCellWidthLeft(int x){
        if(x >= 0 ){
            return true;
        }
        return false;
    }

    /**
     * Проверка пересечения нижней границы поля
     */
    public boolean existenceCellHeightDown(int y){
        if( y < mField.getHeight()){
            return true;
        }
        return false;
    }

    /**
     * Проверка пересечения верхней границы поля
     */
    public boolean existenceCellHeightUp(int y){
        if(y >= 0 ){
            return true;
        }
        return false;
    }

    /**
     * Вернуть объект контроллера столкновений
     */
    public ChoiceCollision getChoiceCollision() {
        return this.mChoiceCollision;
    }

    /**
     * Вернуть поле
     */
    public MyField getField() {
        return this.mField;
    }

}
