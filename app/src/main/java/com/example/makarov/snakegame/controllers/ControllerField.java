package com.example.makarov.snakegame.controllers;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Snake;
import com.example.makarov.snakegame.handlerСollision.ControllerCollision;
import com.example.makarov.snakegame.playingField.Field;
/**
 * класс упраления полем
 * изменяет состояние ячеек поля
 * Классу ControllerCollision передаёт объекты столкновение
 * А так же удаляет, добавляет, меняет позицию объектов или очищает поле
 */
public class ControllerField implements ObjectController {

    private final Field mField;
    private ControllerCollision mControllerCollision;

    public ControllerField(Field field){
        this.mField = field;
        mControllerCollision = new ControllerCollision(mField);
    }
    /**
     * поитерационный процесс изенения состояний на поле
     */
    @Override
    public boolean nextMove() {

        return false;
    }
    /**
     *
     */
    @Override
    public FieldObject getObject() {
        return null;
    }
    /**
     * В методе следующее происходит :
     * 1)если место куда пытаемся добавить пустое, тогда добавляем
     * 2)если объект змейка или её компонент , тогда обработчик столкновений обрабатывает уже всё
     * 3)иначе добавляем этот объект на другое свободное место
     */
    public void addObject(FieldObject object, int x, int y) throws DuplicateObjectException {
        /**
         * проверка, нету ли этого объекта в Collection<FieldObject> objectsField данной карты
         */
        if (mField.getCodeFieldByPosition(x, y) == mField.getCODE_ON_THE_MAP()){
            mField.addObject(object, x, y);
        }
        else if (mField.getCodeFieldByPosition(object.getX(), object.getY())
                == Snake.CODE_SNAKE_ON_THE_MAP){
            mControllerCollision.solutionCollision(object, x, y);
        } else {
            addRandomObject(object);
        }
    }
    /**
     * В методе следующее происходит :
     * 1)с помощью MyField.isEmptyField находим свободное место и добавляем addObject
     */
    public void addRandomObject(FieldObject object) throws DuplicateObjectException {
        /**
         * проверка, нету ли этого объекта в Collection<FieldObject> objectsField данной карты
         */
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
    /**
     * надо написать
     */
    public void changeObjectLocation(FieldObject object, int x, int y) throws NotFoundObjectException {
        /**
         * проверка, существует ли этот объект в Collection<FieldObject> objectsField данной карты
         */
    }
    /**
     * вернуть объект контроллера столкновений
     */
    public ControllerCollision getControllerCollision() {
        return this.mControllerCollision;
    }
}
