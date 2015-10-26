package com.example.makarov.snakegame.playingField;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Snake;
import com.example.makarov.snakegame.handlerСollision.ChoiceCollision;
/**
 * Класс упраления полем
 * изменяет состояние ячеек поля
 * Классу ChoiceCollision передаёт объекты столкновение
 * А так же удаляет, добавляет, меняет позицию объектов или очищает поле
 */
public class ControllerField  {

    private final Field mField;
    private ChoiceCollision mChoiceCollision;

    public ControllerField(Field field){
        this.mField = field;
        mChoiceCollision = new ChoiceCollision(mField);
    }
    /**
     * В методе следующее происходит :
     * 1)проверка, нету ли этого объекта в Collection<FieldObject> objectsField данной карты
     * 2)если место куда пытаемся добавить пустое, тогда добавляем
     * 3)если объект змейка или её компонент , тогда обработчик столкновений обрабатывает уже всё
     * 4)иначе добавляем этот объект на другое свободное место
     */
    public void addObject(FieldObject objectStress, int x, int y) throws DuplicateObjectException {
        if(mField.getListObject().contains(objectStress)) {
            if (mField.isEmptyField(x, y)) {
                mField.addObject(objectStress, x, y);
            } else if (mField.getCodeFieldByPosition(objectStress.getX(), objectStress.getY())
                    == Snake.CODE_SNAKE_ON_THE_MAP) {
                FieldObject objectCollisions = mField.getFieldObject(x, y);
                mChoiceCollision.solutionCollision(objectStress, objectCollisions);
            } else {
                addRandomObject(objectStress);
            }
        }
    }
    /**
     * В методе следующее происходит :
     * 1)Находим свободное место и добавляем addObject
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
    public ChoiceCollision getControllerCollision() {
        return this.mChoiceCollision;
    }
    /**
     * Вернуть поле на котором расставляем объекты
     */
    public Field getField() {
        return this.mField;
    }

}
