package com.example.makarov.snakegame.view;

import com.example.makarov.snakegame.FieldProvider;
import com.example.makarov.snakegame.singleton.IconLoader;
import com.example.makarov.snakegame.objects.Bomb;
import com.example.makarov.snakegame.objects.FieldObject;
import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.objects.TestObject;
import com.example.makarov.snakegame.objects.Vegetable;
import com.example.makarov.snakegame.objects.Wall;

/**
 * Класс фабрики View элементов игры
 */
public class ViewFactory {

    private IconLoader mIconLoader;
    private FieldProvider mFieldProvider;

    /**
     * В конструктор объект содержащий все картинки игры и провайдер поля для размеров картинок
     */
    public ViewFactory (IconLoader loader, FieldProvider fieldProvider){
        mIconLoader = loader;
        mFieldProvider = fieldProvider;
    }

    /**
     * В методе по объекту поля определяем и создаем View, а также возвращаем её
     */
    public View createView(FieldObject object) {
        View objectView = null;
        if (object instanceof Snake) {
            objectView = new SnakeView((Snake)object, mFieldProvider, mIconLoader);
        } else if (object instanceof Wall) {
            objectView = new WallView(object, mFieldProvider, mIconLoader);
        } else if (object instanceof Bomb) {
            objectView = new BombView(object, mFieldProvider, mIconLoader);
        } else if (object instanceof Fruite) {
            objectView = new FruiteView(object, mFieldProvider, mIconLoader);
        } else if (object instanceof Vegetable) {
            objectView = new VegetableView(object, mFieldProvider, mIconLoader);
        } else if (object instanceof TestObject) {
            objectView = new TestObjectView(object, mFieldProvider, mIconLoader);
        }
        return objectView;
    }
}
