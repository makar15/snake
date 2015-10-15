package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.FieldObject;

public interface HandlerCollision {
    /**
     * Интерфейс обработки столкновений
     * в метод на вход объект и координаты на которых объект
     * столкновение которых разруливает метод
     * путем изменения , удаления и.т.д  переменных или самих объектов с поля
     */
    void processingCollision(FieldObject object, int x, int y);
}
