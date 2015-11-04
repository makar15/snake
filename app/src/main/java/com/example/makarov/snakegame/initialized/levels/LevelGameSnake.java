package com.example.makarov.snakegame.initialized.levels;

import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.controllers.TouchResponseSnakeController;
import com.example.makarov.snakegame.objects.Bomb;
import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.initialized.FieldProvider;
import com.example.makarov.snakegame.initialized.IconLoader;
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
public class LevelGameSnake {

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
         * Создаем:
         *
         */
        mGameSnake = gameSnake;
        mIconLoader = iconLoader;

        /*
         * Создаем:
         *
         */
        MyField myField = new MyField(18, 32);
        mFieldProvider = new FieldProvider(mGameSnake, myField.getWidth() ,myField.getHeight());
        myFieldView = new FieldView(myField, mFieldProvider, mIconLoader);

        /*
         * Создаем:
         *
         */
        Snake mySnake = new Snake(4);
        ObjectController myObjContr =
                new TouchResponseSnakeController(myField, mySnake, mGameSnake, mFieldProvider);
        myField.addObject(mySnake, 0, 0);
        View mySnakeView =
                new SnakeView(mySnake, mFieldProvider, mIconLoader);

        /*
         * В списки добавляем
         */
        mListController.add(myObjContr);
        mListView.add(mySnakeView);

        /*
         * Создаем:
         *
         */
        for(int i = 0; i < 5; i++){
            Fruite myFruite = new Fruite();
            myField.addRandomObject(myFruite);
            View myFruiteView =
                    new FruiteView(myFruite, mFieldProvider, mIconLoader);
            mListView.add(myFruiteView);
        }

        /*
         * Создаем:
         *
         */
        for(int i = 0; i < 2; i++){
            Bomb myBomb = new Bomb();
            myField.addRandomObject(myBomb);
            View myBombView =
                    new BombView(myBomb, mFieldProvider, mIconLoader);
            mListView.add(myBombView);
        }

        /*
         * Создаем:
         *
         */
        for(int i = 0; i < 7; i++){
            Wall myWall = new Wall();
            myField.addRandomObject(myWall);
            View myWallView =
                    new WallView(myWall, mFieldProvider, mIconLoader);
            mListView.add(myWallView);
        }

        /*
         * Создаем:
         *
         */
        for(int i = 0; i < 2; i++){
            Vegetable myVegetable = new Vegetable();
            myField.addRandomObject(myVegetable);
            View myVegetableView =
                    new VegetableView(myVegetable, mFieldProvider, mIconLoader);
            mListView.add(myVegetableView);
        }
    }

    /**
     * Вернуть объект прорисовывания самого поля игры
     */
    public FieldView getFieldView() {
        return myFieldView;
    }

    /**
     * Гет метод списка контроллеров
     */
    public Collection<ObjectController> getControllers(){
        return mListController;
    }

    /**
     * Гет метод списка объектовView
     */
    public Collection<View> getViews(){
        return mListView;
    }
}
