package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.FieldObject;
/**
 * Интерфейс обработки столкновений
 */
public interface HandlerCollision<T extends FieldObject, V extends FieldObject> {
    /**
     * в метод на вход два объекта
     * столкновение которых разруливает метод
     * путем изменения , удаления и.т.д  переменных или самих объектов с поля
     */
    void processingCollision(T objectFirst, V objectSecond);
}
