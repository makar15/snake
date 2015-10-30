package com.example.makarov.snakegame.initialized;

import android.content.Context;
import android.view.SurfaceHolder;
import com.example.makarov.snakegame.controllers.ControlTheFieldObject;
import com.example.makarov.snakegame.controllers.ControllerUnmovingObjects;
import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.fieldObjects.Fruite;
import com.example.makarov.snakegame.fieldObjects.TestObject;
import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.playingField.MyField;
import com.example.makarov.snakegame.view.TestObjectView;
import com.example.makarov.snakegame.view.FieldView;
import com.example.makarov.snakegame.view.FruiteView;
import com.example.makarov.snakegame.view.View;
import java.util.Collection;
import java.util.LinkedList;
/**
 * Класс инициализации всех объектов игры, и всех объектов отрисовки в игре
 */
public class InitializationGameSnake {

    private Context mContext;
    private SurfaceHolder mHolder;
    private GameSnakeSurfaceView mGameSnake;
    private Collection<ObjectController> mListController = new LinkedList<>();
    private Collection<View> mListView = new LinkedList<>();
    private FieldView myFieldView;
    /**
     * В конструктор Холдер, контекст на котором отрисовываем игру
     */
    public InitializationGameSnake(SurfaceHolder holder,
                                   Context context, GameSnakeSurfaceView gameSnake){
        mHolder = holder;
        mContext = context;
        mGameSnake = gameSnake;
        /**
         * Создаем:
         *  поле с размерами 27 на 48
         *  объект передвижения по полю
         *  контроллер который передвигает объект(по часовой стрелке)
         *  фрукт
         *  контроллер для фрукта(без передвижения по карте)
         */
        Field myField = new MyField(27, 48);
        TestObject myTestObj = new TestObject();
        ObjectController myObjController = new ControlTheFieldObject(myField, myTestObj);
        Fruite myFruite = new Fruite();
        ObjectController myFruiteController = new ControllerUnmovingObjects(myField, myFruite);
        /**
         * Создаем:
         *  провайдер поля
         *  полеView
         *  тестОбъектView
         *  фруктView
         */
        FieldProvider mFieldProvider = new FieldProvider
                (mHolder, myField);
        myFieldView = new FieldView
                (myField, mContext, mFieldProvider);
        TestObjectView myObjectView = new TestObjectView
                (myTestObj, mContext, mFieldProvider);
        FruiteView myFruiteView = new FruiteView
                (myFruite, mContext, mFieldProvider);
        /**
         * В списки добавляем
         */
        {
            mListController.add(myObjController);
            mListView.add(myObjectView);
            mListController.add(myFruiteController);
            mListView.add(myFruiteView);
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
    public Collection<ObjectController> getListController(){
        return mListController;
    }
    /**
     * Гет метод списка объектовView
     */
    public Collection<View> getListView(){
        return mListView;
    }
}
