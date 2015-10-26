package com.example.makarov.snakegame;

import android.content.Context;
import com.example.makarov.snakegame.controllers.ControlTheFieldObject;
import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.fieldObjects.TestObject;
import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.playingField.MyField;
import com.example.makarov.snakegame.view.FieldObjectView;
import com.example.makarov.snakegame.view.FieldProvider;
import com.example.makarov.snakegame.view.FieldView;
import com.example.makarov.snakegame.view.GameSnakeSurfaceView;
import com.example.makarov.snakegame.view.View;
import java.util.Collection;
import java.util.LinkedList;
/**
 * Класс инициализации всех объектов игры , и всех объектов отрисовки в игре
 */
public class InitializationGameSnake {

    private GameSnakeSurfaceView mGameSnake;
    private Collection<ObjectController> mListController = new LinkedList<>();
    private Collection<View> mListView = new LinkedList<>();
    private Context mContext;
    /**
     * В конструктор контекст
     */
    public InitializationGameSnake(Context context, GameSnakeSurfaceView gameSnake){
        mContext = context;
        mGameSnake = gameSnake;
    }
    /**
     * Создаем поле с размерами 54 на 96
     * Создаем объект передвижения по полю
     * Создаем контроллер который передвигает объект(по часовой стрелке)
     */
    Field myField = new MyField(54, 96);
    TestObject myFieldObj = new TestObject();
    ObjectController myObjController = new ControlTheFieldObject(myField, myFieldObj);
    /**
     * Инициализируем: провайдер поля по которому с помощью канваса узнаем размеры в пикселях
     * Объект отрисовывания в игре
     */
    FieldProvider mFieldProvider = new FieldProvider
            (mGameSnake.getDrawThread().getCanvas(), myField);
    FieldObjectView myObjectView = new FieldObjectView
            (myFieldObj, mContext, mFieldProvider);
    FieldView myFieldView = new FieldView(mContext, mFieldProvider);
    /**
     * В списки добавляем
     */
    {
        mListController.add(myObjController);
        mListView.add(myFieldView);
        mListView.add(myObjectView);
    }
    /**
     * Гет метод списка контроллеров
     */
    public Collection<ObjectController> getListController(){
        return mListController;
    }
    /**
     * Гет метод списка объект отрисовывания
     */
    public Collection<View> getListView(){
        return mListView;
    }
}
