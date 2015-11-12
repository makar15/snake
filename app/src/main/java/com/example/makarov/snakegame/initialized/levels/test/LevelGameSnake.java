package com.example.makarov.snakegame.initialized.levels.test;

import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.controllers.TouchResponseSnakeController;
import com.example.makarov.snakegame.initialized.levels.Level;
import com.example.makarov.snakegame.objects.Bomb;
import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.FieldProvider;
import com.example.makarov.snakegame.IconLoader;
import com.example.makarov.snakegame.field.MyField;
import com.example.makarov.snakegame.objects.Vegetable;
import com.example.makarov.snakegame.objects.Wall;
import com.example.makarov.snakegame.view.BombView;
import com.example.makarov.snakegame.view.FieldView;
import com.example.makarov.snakegame.view.FruiteView;
import com.example.makarov.snakegame.view.SnakeView;
import com.example.makarov.snakegame.view.VegetableView;
import com.example.makarov.snakegame.view.View;
import com.example.makarov.snakegame.view.WallView;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Класс уровня тестирования игры
 * инициализация всех объектов игры, и всех объектов отрисовки в игре
 */
public class LevelGameSnake implements Level {

    private android.view.View mGameSnake;
    private Collection<ObjectController> mListController = new LinkedList<>();
    private Collection<com.example.makarov.snakegame.view.View> mListView = new LinkedList<>();
    private FieldView myFieldView;
    private IconLoader mIconLoader;
    private FieldProvider mFieldProvider;

    /**
     * В конструктор View на котором отрисовываем игру, объукт со всеми Bitmap-ами для игры
     */
    public LevelGameSnake(android.view.View gameSnake, IconLoader iconLoader){

        /*
         * Инициализируем:
         * view экран, на котором все отрисовываем
         * объект со всеми содержащими bitmap-ами
         */
        mGameSnake = gameSnake;
        mIconLoader = iconLoader;

        /*
         * Создаем:
         * поле с размером 18 на 32
         * провайдер поля
         * view поля
         */

        /*

         */
        MyField myField = new MyField(18, 32);
        mFieldProvider = new FieldProvider(mGameSnake, myField.getWidth() ,myField.getHeight());
        myFieldView = new FieldView(myField, mFieldProvider, mIconLoader);

        /*
         * Создаем:
         * змейку с длинной 3
         * контроллер для змейки
         * ставим на карту
         * view змейки
         */
        Snake mySnake = new Snake(5);
        ObjectController myObjContr =
                new TouchResponseSnakeController(myField, mySnake, mGameSnake, mFieldProvider);
        myField.addObject(mySnake, 5, 5);
        View mySnakeView =
                new SnakeView(mySnake, mFieldProvider, mIconLoader);

        /*
         * Добавляем в списки
         */
        mListController.add(myObjContr);
        mListView.add(mySnakeView);

        /*
         * Создаем:
         * 5 фруктов
         * для каждой: view отрисовки фрукта
         * ставим на рандомное место на карте и добавляем в список view-ху
         */
        for(int i = 0; i < 5; i++){
            Fruite myFruite = new Fruite();
            myField.addRandomObject(myFruite);
            View myFruiteView =
                    new FruiteView(myFruite, mFieldProvider, mIconLoader);
            mListView.add(myFruiteView);
        }

        /*
         * Создаем (по принципу фрукта):
         * 2 бомбы
         */
        for(int i = 0; i < 2; i++){
            Bomb myBomb = new Bomb();
            myField.addRandomObject(myBomb);
            View myBombView =
                    new BombView(myBomb, mFieldProvider, mIconLoader);
            mListView.add(myBombView);
        }

        /*
         * Создаем (по принципу фрукта):
         * 7 стенок
         */
        for(int i = 0; i < 8; i++){
            Wall myWall = new Wall();
            myField.addRandomObject(myWall);
            View myWallView =
                    new WallView(myWall, mFieldProvider, mIconLoader);
            mListView.add(myWallView);
        }

        /*
         * Создаем (по принципу фрукта):
         * 2 овощя
         */
        for(int i = 0; i < 2; i++){
            Vegetable myVegetable = new Vegetable();
            myField.addRandomObject(myVegetable);
            View myVegetableView =
                    new VegetableView(myVegetable, mFieldProvider, mIconLoader);
            mListView.add(myVegetableView);
        }


    }

    @Override
    public FieldView getFieldView() {
        return myFieldView;
    }

    @Override
    public Collection<ObjectController> getControllers(){
        return mListController;
    }

    @Override
    public Collection<View> getViews(){
        return mListView;
    }
}
