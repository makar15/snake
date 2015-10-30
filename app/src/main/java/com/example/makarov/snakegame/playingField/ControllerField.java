package com.example.makarov.snakegame.playingField;

import com.example.makarov.snakegame.exception.DuplicateObjectException;
import com.example.makarov.snakegame.exception.NotFoundObjectException;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.TestObject;
import com.example.makarov.snakegame.handlerСollision.ChoiceCollision;
/**
 * Класс упраления полем
 * Классу ChoiceCollision передаёт объекты столкновений
 * А так же удаляет, добавляет, меняет позицию объектов или очищает поле
 */
public class ControllerField  {

    private final Field mField;
    private ChoiceCollision mChoiceCollision;
    /**
     * В конструктор поле на котором будем проводить операции
     * Инициализируем объект определяющий между кем столкновение
     */
    public ControllerField(Field field){
        this.mField = field;
        mChoiceCollision = new ChoiceCollision(mField);
    }
    /**
     * Добавить объект на указанные координаты на поле с рассмотрением коллизии
     * В методе следующее происходит :
     * 1)сохраняем координаты и код объекта ,который хоти добавить
     * 2)удаляем объект с текущего места на карте
     * 3)проверка, нету ли этого объекта в списке объектов данной карты
     * 4)если место куда пытаемся добавить пустое, тогда добавляем
     * 5)если объект тестОбъект, тогда обработчик столкновений обрабатывает уже всё
     * (ВОТ ТУТ else if согласен что не очень хорошо сделано, пока не думал как по другому сделать)
     * 6)иначе добавляем этот объект на другое свободное место
     */
    public void addObject(FieldObject objectStress, int newX, int newY) throws DuplicateObjectException {
        int saveX = objectStress.getX();
        int saveY = objectStress.getY();
        int saveCode = mField.getCodeFieldByPosition(saveX, saveY);
        mField.removeObject(objectStress);
        if(!mField.getListObject().contains(objectStress)) {
            if (mField.isEmptyField(newX, newY)) {
                mField.addObject(objectStress, newX, newY);
            } else if (saveCode == TestObject.CODE_TEST_OBJECT_ON_THE_MAP) {
                FieldObject objectCollisions = mField.getFieldObject(newX, newY);
                mChoiceCollision.solutionCollision(objectStress, objectCollisions);
            } else {
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
     */
    public void changeObjectLocation(FieldObject object, int newX, int newY) throws NotFoundObjectException {
        addObject(object, newX, newY);
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
    public Field getField() {
        return this.mField;
    }

}
