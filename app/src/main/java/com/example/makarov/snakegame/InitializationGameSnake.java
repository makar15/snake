package com.example.makarov.snakegame;

import android.content.Context;
import android.view.SurfaceHolder;
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
    private SurfaceHolder mHolder;
    /**
     * В конструктор контекст
     */
    public InitializationGameSnake(SurfaceHolder holder,
                                   Context context, GameSnakeSurfaceView gameSnake){
        mHolder = holder;
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
     *                 объект отрисовывания в игре
     */
    FieldProvider mFieldProvider = new FieldProvider
            (mHolder, myField);
    FieldView myFieldView = new FieldView
            (myField, mContext, mFieldProvider);
    FieldObjectView myObjectView = new FieldObjectView
            (myFieldObj, mContext, mFieldProvider);
    /**
     * В списки добавляем
     */
    {
        mListController.add(myObjController);
        mListView.add(myObjectView);
    }
    /**
     * Вернуть объекто прорисовывания самого поля игры
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
     * Гет метод списка объект отрисовывания
     */
    public Collection<View> getListView(){
        return mListView;
    }
}
