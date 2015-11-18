package com.example.makarov.snakegame.level;

import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.view.FieldView;
import com.example.makarov.snakegame.view.View;
import java.util.Collection;

/**
 * Интерфейс Уровня игры
 */
public interface LevelCreator {

    /**
     * Вернуть объект прорисовывания самого поля игры
     */
    FieldView getFieldView();

    /**
     * Гет метод списка контроллеров
     */
    Collection<ObjectController> getControllers();

    /**
     * Гет метод списка объектовView
     */
    Collection<View> getViews();
}
