package com.example.makarov.snakegame.initialized.levels.test;

import com.example.makarov.snakegame.controllers.ControllerTouchResponse;
import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.initialized.levels.Level;
import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.TestObject;
import com.example.makarov.snakegame.FieldProvider;
import com.example.makarov.snakegame.singleton.IconLoader;
import com.example.makarov.snakegame.field.MyField;
import com.example.makarov.snakegame.view.FieldView;
import com.example.makarov.snakegame.view.FruiteView;
import com.example.makarov.snakegame.view.TestObjectView;
import com.example.makarov.snakegame.view.View;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Класс уровня тестирования игры
 * инициализация всех объектов игры, и всех объектов отрисовки в игре
 */
public class LevelTestGame implements Level {

    private android.view.View mGameSnake;
    private Collection<ObjectController> mListController = new LinkedList<>();
    private Collection<com.example.makarov.snakegame.view.View> mListView = new LinkedList<>();
    private FieldView myFieldView;
    private IconLoader mIconLoader;
    private FieldProvider mFieldProvider;

    /**
     * В конструктор View на котором отрисовываем игру, объукт со всеми Bitmap-ами для игры
     */
    public LevelTestGame(android.view.View gameSnake, IconLoader iconLoader){

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
         * */
        TestObject myTestObj = new TestObject();
        ObjectController myObjController =
                new ControllerTouchResponse(myField, myTestObj, mGameSnake, mFieldProvider);
        myField.addRandomObject(myTestObj);
        TestObjectView myObjectView =
                new TestObjectView(myTestObj, mFieldProvider, mIconLoader);

        /*
         * В списки добавляем
         *
         */
        mListController.add(myObjController);
        mListView.add(myObjectView);

        /*
         * Создаем:
         *
         */
        for(int i = 0; i < 7; i++){
            Fruite myFruite = new Fruite();
            myField.addRandomObject(myFruite);
            FruiteView myFruiteView =
                    new FruiteView(myFruite, mFieldProvider, mIconLoader);
            mListView.add(myFruiteView);
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
